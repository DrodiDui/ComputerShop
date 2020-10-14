package by.kapitonov.computer.shop.backend.service;

import by.kapitonov.computer.shop.backend.model.UserStatus;

import java.util.List;

public interface UserStatusService {

    List<UserStatus> getAllUserStatuses();
    UserStatus create(String statusName);

}
