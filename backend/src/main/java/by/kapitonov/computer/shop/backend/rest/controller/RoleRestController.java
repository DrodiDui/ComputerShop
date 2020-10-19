package by.kapitonov.computer.shop.backend.rest.controller;

import by.kapitonov.computer.shop.backend.model.Role;
import by.kapitonov.computer.shop.backend.rest.vm.ApiResponse;
import by.kapitonov.computer.shop.backend.rest.vm.RoleVM;
import by.kapitonov.computer.shop.backend.service.RoleService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/roles")
public class RoleRestController {

    private final RoleService roleService;

    public RoleRestController(RoleService roleService) {
        this.roleService = roleService;
    }

    @GetMapping()
    public ResponseEntity<List<Role>> getAllRoles() {

        List<Role> roles = roleService.getAllRoles();

        return new ResponseEntity<>(roles, HttpStatus.OK);
    }

    @PostMapping()
    public ResponseEntity<ApiResponse> createRole(@RequestBody String roleName) {

        roleService.createRole(roleName);

        return new ResponseEntity<>(new ApiResponse("Role successfully created"), HttpStatus.OK);
    }

}