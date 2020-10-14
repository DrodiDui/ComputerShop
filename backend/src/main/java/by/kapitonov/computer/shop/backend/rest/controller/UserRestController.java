package by.kapitonov.computer.shop.backend.rest.controller;

import by.kapitonov.computer.shop.backend.model.User;
import by.kapitonov.computer.shop.backend.rest.mapper.UserMapper;
import by.kapitonov.computer.shop.backend.rest.vm.ApiResponse;
import by.kapitonov.computer.shop.backend.rest.vm.SecretVM;
import by.kapitonov.computer.shop.backend.rest.vm.UserVM;
import by.kapitonov.computer.shop.backend.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/users")
public class UserRestController {

    private final UserService userService;

    public UserRestController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<UserVM> getUserById(@PathVariable(name = "id") Long id) {

        User user = userService.getUserById(id);
        UserVM userVM = UserMapper.INSTANCE.userToVM(user);

        return new ResponseEntity<>(userVM, HttpStatus.OK);
    }

    @PutMapping("/update/secret-question")
    public ResponseEntity<ApiResponse> updateUserSecretQuestionAndAnswer(@RequestBody SecretVM secretVM) {

        userService.changeUserSecretQuestionAndAnswer(
                secretVM.getSecretQuestion(),
                secretVM.getSecretQuestionAnswer()
        );

        return new ResponseEntity<>(new ApiResponse("User successfully updated"), HttpStatus.OK);
    }

    @DeleteMapping
    public ResponseEntity<ApiResponse> deleteUser() {
        userService.changeUserStatusToDelete();

        return new ResponseEntity<>(new ApiResponse("User successfully deleted"), HttpStatus.OK);
    }
}
