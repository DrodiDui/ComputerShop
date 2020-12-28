package by.kapitonov.computer.shop.backend.service.impl;

import by.kapitonov.computer.shop.backend.exception.RoleNotFoundException;
import by.kapitonov.computer.shop.backend.model.Role;
import by.kapitonov.computer.shop.backend.repository.RoleRepository;
import by.kapitonov.computer.shop.backend.service.RoleService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoleServiceImpl implements RoleService {
    private static final Logger LOGGER = LoggerFactory.getLogger(RoleServiceImpl.class);

    private final RoleRepository roleRepository;

    public RoleServiceImpl(RoleRepository roleRepository) {
        this.roleRepository = roleRepository;
    }

    @Override
    public List<Role> getAllRoles() {
        List<Role> roles = roleRepository.findAll();

        if (roles.isEmpty()) {
            throw new RoleNotFoundException("Roles haven't been found");
        }

        return roles;
    }

    @Override
    public Role getRoleByRoleName(String roleName) {
        return roleRepository.findByRoleName(roleName)
                .orElseThrow(
                        () -> new RoleNotFoundException("Role hasn't been found")
                );
    }

    @Override
    public Role createRole(String roleName) {
        return roleRepository.save(new Role(roleName));
    }
}
