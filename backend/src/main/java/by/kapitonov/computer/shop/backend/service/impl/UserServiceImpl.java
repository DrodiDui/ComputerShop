package by.kapitonov.computer.shop.backend.service.impl;

import by.kapitonov.computer.shop.backend.constant.RoleConstants;
import by.kapitonov.computer.shop.backend.constant.UserStatusConstants;
import by.kapitonov.computer.shop.backend.exception.UserNotFoundException;
import by.kapitonov.computer.shop.backend.model.*;
import by.kapitonov.computer.shop.backend.repository.UserRepository;
import by.kapitonov.computer.shop.backend.service.RoleService;
import by.kapitonov.computer.shop.backend.service.SecretQuestionService;
import by.kapitonov.computer.shop.backend.service.UserService;
import by.kapitonov.computer.shop.backend.service.UserStatusService;
import by.kapitonov.computer.shop.backend.service.dto.UserDTO;
import by.kapitonov.computer.shop.backend.util.RandomUtils;
import by.kapitonov.computer.shop.backend.util.SecurityUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class UserServiceImpl implements UserService {
    private static final Logger LOGGER = LoggerFactory.getLogger(UserServiceImpl.class);

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final RoleService roleService;
    private final UserStatusService userStatusService;
    private final SecretQuestionService secretQuestionService;

    public UserServiceImpl(UserRepository userRepository,
                           PasswordEncoder passwordEncoder,
                           RoleService roleService,
                           UserStatusService userStatusService,
                           SecretQuestionService secretQuestionService) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
        this.roleService = roleService;
        this.userStatusService = userStatusService;
        this.secretQuestionService = secretQuestionService;
    }

    @Override
    public Page<User> getAllUsers(Pageable pageable) {
        Page<User> userPage = userRepository.findAll(pageable);

        if (!userPage.hasContent()) {
            throw new UserNotFoundException("Users haven't been found");
        }

        return userPage;
    }

    @Override
    public User getUserById(Long id) {
        LOGGER.info("RETURN USER BY ID: {}", id);
        return userRepository.findById(id)
                .orElseThrow(
                        () -> new UserNotFoundException("User hasn't been found")
                );
    }

    @Override
    public User getUserByUsernameOrEmail(String usernameOrEmail) {
        return userRepository.findByUsernameOrEmail(usernameOrEmail, usernameOrEmail)
                .orElseThrow(
                        () -> new UserNotFoundException("User hasn't been found")
                );
    }

    @Override
    public User activationUserAccount(String activationCode) {
        LOGGER.info("RETURN ACTIVE USER ACCOUNT");
        return userRepository.findByActivationCode(activationCode)
                .map(user -> {
                    user.setActivationCode(null);
                    user.setStatus(
                            userStatusService.getUserStatusByName(UserStatusConstants.ACTIVE)
                    );
                    return userRepository.save(user);
                })
                .orElseThrow(
                        () -> new UserNotFoundException("User hasn't been found")
                );
    }

    @Override
    public User createUser(UserDTO userDTO) {
        LOGGER.info("CREATE AND RETURN NEW USER");

        User user = User.builder()
                .username(userDTO.getUsername())
                .email(userDTO.getEmail())
                .role(roleService.getRoleByRoleName(userDTO.getRole()))
                .customer(Customer.builder().build())
                .build();

        if (userDTO.getPassword().isEmpty()) {

            String password = RandomUtils.generatePassword();
            user.setPassword(passwordEncoder.encode(password));
            user.setActivationCode(UUID.randomUUID().toString());
            user.setStatus(userStatusService.getUserStatusByName(UserStatusConstants.INACTIVE));

            //send activation message email

        } else {

            user.setPassword(passwordEncoder.encode(userDTO.getPassword()));
            user.setStatus(userStatusService.getUserStatusByName(UserStatusConstants.ACTIVE));

            //send activation message email method

        }

        return userRepository.save(user);
    }

    @Override
    public User registrationUser(UserDTO userDTO) {
        LOGGER.info("REGISTRATION AND RETURN USER");
        User user = User.builder()
                .username(userDTO.getUsername())
                .email(userDTO.getEmail())
                .password(passwordEncoder.encode(userDTO.getPassword()))
                .activationCode(UUID.randomUUID().toString())
                .role(roleService.getRoleByRoleName(RoleConstants.USER))
                .status(userStatusService.getUserStatusByName(UserStatusConstants.INACTIVE))
                .customer(Customer.builder().build())
                .secretQuestion(secretQuestionService.getSecretQuestionByName(userDTO.getSecretQuestion()))
                .secretQuestionAnswer(userDTO.getSecretQuestionAnswer())
                .build();

        //send activation message email method

        return userRepository.save(user);
    }

    @Override
    public User passwordReset(String oldPassword, String newPassword) {
        LOGGER.info("RESET USER PASSWORD");
        return userRepository.findById(SecurityUtils.getUserId())
                .filter(passwordEncoder.encode(oldPassword)::equals)
                .map(user -> {
                    user.setPassword(passwordEncoder.encode(newPassword));
                    return userRepository.save(user);
                })
                .orElseThrow(
                        () -> new UserNotFoundException("User hasn't been found")
                );
    }

    @Override
    public User changeUserSecretQuestionAndAnswer(String secretQuestion, String questionAnswer) {
        return userRepository.findById(SecurityUtils.getUserId())
                .map(user -> {
                    user.setSecretQuestion(secretQuestionService.getSecretQuestionByName(secretQuestion));
                    user.setSecretQuestionAnswer(questionAnswer);
                    return userRepository.save(user);
                })
                .orElseThrow(
                        () -> new UserNotFoundException("User hasn't been found")
                );
    }

    @Override
    public User changeUserStatusToDelete() {
        LOGGER.info("CHANGE USER STATUS TO DELETE");
        return userRepository.findById(SecurityUtils.getUserId())
                .map(user -> {
                    user.setActivationCode(UUID.randomUUID().toString());
                    user.setStatus(userStatusService.getUserStatusByName(UserStatusConstants.DELETED));
                    //send message email
                    return userRepository.save(user);
                })
                .orElseThrow(
                        () -> new UserNotFoundException("User hasn't been found")
                );
    }

    @Override
    public void deleteUser(Long id) {
        LOGGER.info("DELETE USER ACCOUNT BY ID: {}", id);
        userRepository.deleteById(id);
    }
}
