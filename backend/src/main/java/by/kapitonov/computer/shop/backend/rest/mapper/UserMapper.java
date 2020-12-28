package by.kapitonov.computer.shop.backend.rest.mapper;

import by.kapitonov.computer.shop.backend.exception.CustomerNotFoundException;
import by.kapitonov.computer.shop.backend.exception.GenderNotFoundException;
import by.kapitonov.computer.shop.backend.exception.UserNotFoundException;
import by.kapitonov.computer.shop.backend.model.Customer;
import by.kapitonov.computer.shop.backend.model.Gender;
import by.kapitonov.computer.shop.backend.model.User;
import by.kapitonov.computer.shop.backend.rest.vm.CustomerVM;
import by.kapitonov.computer.shop.backend.rest.vm.SignUpVm;
import by.kapitonov.computer.shop.backend.rest.vm.UserVM;
import by.kapitonov.computer.shop.backend.service.dto.UserDTO;

public final class UserMapper {

    public static UserDTO signUpVMtoUserDTO(SignUpVm signUpVm) {
        if (signUpVm == null) {
            throw new IllegalArgumentException("SignUpV cannot been mapped to UserDTO entity");
        }
        return UserDTO.builder()
                .username(signUpVm.getUsername())
                .email(signUpVm.getEmail())
                .password(signUpVm.getPassword())
                .secretQuestion(signUpVm.getSecretQuestion())
                .secretQuestionAnswer(signUpVm.getQuestionAnswer())
                .build();
    }

    public static UserVM userToUserVM(User user) {
        if (user == null) {
            throw new UserNotFoundException("User cannot been mapped to UserVM entity");
        }
        return UserVM.builder()
                .username(user.getUsername())
                .email(user.getEmail())
                .customer(getCustomerVM(user.getCustomer()))
                .build();
    }

    private static CustomerVM getCustomerVM(Customer customer) {
        if (customer == null) {
            return null;
        }
        return CustomerVM.builder()
                .firstName(customer.getFirstName())
                .lastName(customer.getLastName())
                .gender(getGender(customer.getGender()))
                .cellPhone(customer.getCellPhone())
                /*.country(customer.getAddress().getCountry())
                .city(customer.getAddress().getCity())
                .street(customer.getAddress().getStreet())
                .houseNumber(customer.getAddress().getHouseNumber())*/
                .build();
    }

    private static String getGender(Gender gender) {
        if (gender == null) {
            return null;
        }
        return gender.getGenderName();
    }
}
