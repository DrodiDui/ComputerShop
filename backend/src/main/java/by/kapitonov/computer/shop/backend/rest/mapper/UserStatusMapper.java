package by.kapitonov.computer.shop.backend.rest.mapper;

import by.kapitonov.computer.shop.backend.model.UserStatus;
import by.kapitonov.computer.shop.backend.rest.vm.UserStatusVM;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface UserStatusMapper {
    UserStatusMapper INSTANCE = Mappers.getMapper(UserStatusMapper.class);

    List<UserStatusVM> entityListToVMList(List<UserStatus> userStatuses);
}
