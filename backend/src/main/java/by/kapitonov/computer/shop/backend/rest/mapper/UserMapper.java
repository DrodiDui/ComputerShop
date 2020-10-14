package by.kapitonov.computer.shop.backend.rest.mapper;

import by.kapitonov.computer.shop.backend.model.User;
import by.kapitonov.computer.shop.backend.rest.vm.SignUpVm;
import by.kapitonov.computer.shop.backend.rest.vm.UserVM;
import by.kapitonov.computer.shop.backend.service.dto.UserDTO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface UserMapper {
    UserMapper INSTANCE = Mappers.getMapper(UserMapper.class);

    UserDTO vmToDTO(SignUpVm signUpVm);

    UserVM userToVM(User user);
}
