package by.kapitonov.computer.shop.backend.rest.controller;

import by.kapitonov.computer.shop.backend.model.User;
import by.kapitonov.computer.shop.backend.rest.mapper.UserMapper;
import by.kapitonov.computer.shop.backend.rest.vm.ApiResponse;
import by.kapitonov.computer.shop.backend.rest.vm.LoginVM;
import by.kapitonov.computer.shop.backend.rest.vm.SignUpVm;
import by.kapitonov.computer.shop.backend.rest.vm.TokenResponse;
import by.kapitonov.computer.shop.backend.security.jwt.TokenProvider;
import by.kapitonov.computer.shop.backend.service.UserService;
import by.kapitonov.computer.shop.backend.service.dto.UserDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/auth")
public class AuthRestController {

    private final UserService userService;
    private final TokenProvider tokenProvider;
    private final AuthenticationManager authenticationManager;

    public AuthRestController(UserService userService,
                              TokenProvider tokenProvider,
                              AuthenticationManager authenticationManager) {
        this.userService = userService;
        this.tokenProvider = tokenProvider;
        this.authenticationManager = authenticationManager;
    }

    @PostMapping("/login")
    public ResponseEntity<TokenResponse> login(@RequestBody LoginVM loginVM) {

        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(loginVM.getUsernameOrEmail(), loginVM.getPassword())
        );
        String token = tokenProvider.generateToken(authentication);
        User user = userService.getUserByUsernameOrEmail(loginVM.getUsernameOrEmail());

        TokenResponse response = TokenResponse.builder()
                .token(token)
                .id(user.getId())
                .role(String.valueOf(user.getRole()))
                .build();

        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @PostMapping("/registration")
    public ResponseEntity<ApiResponse> registration(@RequestBody SignUpVm signUpVm) {

        UserDTO userDTO = UserMapper.signUpVMtoUserDTO(signUpVm);
        userService.registrationUser(userDTO);

        return new ResponseEntity<>(new ApiResponse("User successfully created"), HttpStatus.OK);
    }
}
