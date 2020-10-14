package by.kapitonov.computer.shop.backend.service;

import by.kapitonov.computer.shop.backend.model.Role;

import java.util.List;

public interface RoleService {

    List<Role> getAllRoles();
    Role createRole(String roleName);

}
