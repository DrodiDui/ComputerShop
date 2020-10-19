package by.kapitonov.computer.shop.backend.rest.mapper;

import by.kapitonov.computer.shop.backend.model.Customer;
import by.kapitonov.computer.shop.backend.model.User;
import by.kapitonov.computer.shop.backend.rest.vm.CustomerVM;
import by.kapitonov.computer.shop.backend.rest.vm.SignUpVm;
import by.kapitonov.computer.shop.backend.rest.vm.UserVM;
import by.kapitonov.computer.shop.backend.service.dto.UserDTO;

public interface UserMapper {

    static UserDTO signUpVMtoUserDTO(SignUpVm signUpVm) {
        if (signUpVm == null) {
            throw new RuntimeException("SignUpV cannot been mapped to UserDTO entity");
        }
        return UserDTO.builder()
                .username(signUpVm.getUsername())
                .email(signUpVm.getEmail())
                .password(signUpVm.getPassword())
                .secretQuestion(signUpVm.getSecretQuestion())
                .secretQuestionAnswer(signUpVm.getQuestionAnswer())
                .build();
    }

    static UserVM userToUserVM(User user) {
        if (user == null) {
            throw new RuntimeException("User cannot been mapped to UserVM entity");
        }



        return UserVM.builder()
                .username(user.getUsername())
                .email(user.getEmail())
                .build();
    }
}
