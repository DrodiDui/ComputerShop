package by.kapitonov.computer.shop.backend.service;

import by.kapitonov.computer.shop.backend.model.User;
import by.kapitonov.computer.shop.backend.service.dto.UserDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface UserService {

    Page<User> getAllUsers(Pageable pageable);

    User getUserById(Long id);
    User getUserByUsernameOrEmail(String username);

    User activationUserAccount(String activationCode);

    User createUser(UserDTO userDTO);
    User registrationUser(UserDTO userDTO);

    User passwordReset(String oldPassword, String newPassword);

    User changeUserSecretQuestionAndAnswer(String secretQuestion, String questionAnswer);

    User changeUserStatusToDelete();
    void deleteUser(Long id);

}
