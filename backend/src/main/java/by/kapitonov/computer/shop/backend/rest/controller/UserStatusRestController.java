package by.kapitonov.computer.shop.backend.rest.controller;

import by.kapitonov.computer.shop.backend.model.UserStatus;
import by.kapitonov.computer.shop.backend.rest.vm.ApiResponse;
import by.kapitonov.computer.shop.backend.rest.vm.UserStatusVM;
import by.kapitonov.computer.shop.backend.service.UserStatusService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/statuses")
public class UserStatusRestController {

    private final UserStatusService statusService;

    public UserStatusRestController(UserStatusService statusService) {
        this.statusService = statusService;
    }

    @GetMapping()
    public ResponseEntity<List<UserStatus>> getAll() {
        List<UserStatus> userStatuses = statusService.getAllUserStatuses();

        return new ResponseEntity<>(userStatuses, HttpStatus.OK);
    }

    @PostMapping()
    public ResponseEntity<ApiResponse> createUserStatus(@RequestBody String statusName) {

        statusService.create(statusName);

        return new ResponseEntity<>(new ApiResponse("User status successfully created"), HttpStatus.OK);
    }
}
