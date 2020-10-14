package by.kapitonov.computer.shop.backend.service.impl;

import by.kapitonov.computer.shop.backend.exception.UserStatusNotFoundException;
import by.kapitonov.computer.shop.backend.model.UserStatus;
import by.kapitonov.computer.shop.backend.repository.UserStatusRepository;
import by.kapitonov.computer.shop.backend.service.UserStatusService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserStatusServiceImpl implements UserStatusService {

    private final UserStatusRepository statusRepository;

    public UserStatusServiceImpl(UserStatusRepository statusRepository) {
        this.statusRepository = statusRepository;
    }

    @Override
    public List<UserStatus> getAllUserStatuses() {
        List<UserStatus> userStatuses = statusRepository.findAll();

        if (userStatuses.isEmpty()) {
            throw new UserStatusNotFoundException("User statuses haven't been found");
        }

        return userStatuses;
    }

    @Override
    public UserStatus create(String statusName) {
        return statusRepository.save(new UserStatus(statusName));
    }
}
