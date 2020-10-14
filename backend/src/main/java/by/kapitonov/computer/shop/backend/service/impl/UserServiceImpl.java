package by.kapitonov.computer.shop.backend.service.impl;

import by.kapitonov.computer.shop.backend.constant.RoleConstants;
import by.kapitonov.computer.shop.backend.constant.UserStatusConstants;
import by.kapitonov.computer.shop.backend.exception.RoleNotFoundException;
import by.kapitonov.computer.shop.backend.exception.SecretQuestionNotFoundException;
import by.kapitonov.computer.shop.backend.exception.UserNotFoundException;
import by.kapitonov.computer.shop.backend.exception.UserStatusNotFoundException;
import by.kapitonov.computer.shop.backend.model.*;
import by.kapitonov.computer.shop.backend.repository.RoleRepository;
import by.kapitonov.computer.shop.backend.repository.SecretQuestionRepository;
import by.kapitonov.computer.shop.backend.repository.UserRepository;
import by.kapitonov.computer.shop.backend.repository.UserStatusRepository;
import by.kapitonov.computer.shop.backend.service.UserService;
import by.kapitonov.computer.shop.backend.service.dto.UserDTO;
import by.kapitonov.computer.shop.backend.util.RandomUtil;
import by.kapitonov.computer.shop.backend.util.SecurityUtil;
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
    private final RoleRepository roleRepository;
    private final UserStatusRepository statusRepository;
    private final SecretQuestionRepository secretQuestionRepository;

    public UserServiceImpl(UserRepository userRepository,
                           PasswordEncoder passwordEncoder,
                           RoleRepository roleRepository,
                           UserStatusRepository statusRepository,
                           SecretQuestionRepository secretQuestionRepository) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
        this.roleRepository = roleRepository;
        this.statusRepository = statusRepository;
        this.secretQuestionRepository = secretQuestionRepository;
    }

    @Override
    public Page<User> getAllUsers(Pageable pageable) {
        return userRepository.findAll(pageable);
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
                            getUserStatus(UserStatusConstants.ACTIVE)
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
                .role(getRole(userDTO.getRole()))
                .customer(Customer.builder().build())
                .build();

        if (userDTO.getPassword().isEmpty()) {

            String password = RandomUtil.generatePassword();
            user.setPassword(passwordEncoder.encode(password));
            user.setActivationCode(UUID.randomUUID().toString());
            user.setStatus(getUserStatus(UserStatusConstants.INACTIVE));

            //send activation message email

        } else {

            user.setPassword(passwordEncoder.encode(userDTO.getPassword()));
            user.setStatus(getUserStatus(UserStatusConstants.ACTIVE));

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
                .role(getRole(RoleConstants.USER))
                .status(getUserStatus(UserStatusConstants.INACTIVE))
                .customer(Customer.builder().build())
                .secretQuestion(getSecretQuestion(userDTO.getSecretQuestion()))
                .secretQuestionAnswer(userDTO.getSecretQuestionAnswer())
                .build();

        //send activation message email method

        return userRepository.save(user);
    }

    @Override
    public User passwordReset(String oldPassword, String newPassword) {
        LOGGER.info("RESET USER PASSWORD");
        return userRepository.findById(SecurityUtil.getUserId())
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
        return userRepository.findById(SecurityUtil.getUserId())
                .map(user -> {
                    user.setSecretQuestion(getSecretQuestion(secretQuestion));
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
        return userRepository.findById(SecurityUtil.getUserId())
                .map(user -> {
                    user.setActivationCode(UUID.randomUUID().toString());
                    user.setStatus(getUserStatus(UserStatusConstants.DELETED));
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

    private UserStatus getUserStatus(String statusName) {
        return statusRepository.findByStatusName(statusName)
                .orElseThrow(
                        () -> new UserStatusNotFoundException("User status hasn't been found")
                );
    }

    private Role getRole(String roleName) {
        return roleRepository.findByRoleName(roleName)
                .orElseThrow(
                        () -> new RoleNotFoundException("Role hasn't been found")
                );
    }

    private SecretQuestion getSecretQuestion(String secretQuestion) {
        return secretQuestionRepository.findBySecretQuestionName(secretQuestion)
                .orElseThrow(
                        () -> new SecretQuestionNotFoundException("Secret question hasn't been fount")
                );
    }
}
