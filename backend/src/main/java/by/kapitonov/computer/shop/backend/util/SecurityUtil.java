package by.kapitonov.computer.shop.backend.util;

import by.kapitonov.computer.shop.backend.security.UserPrincipal;
import by.kapitonov.computer.shop.backend.service.impl.UserServiceImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;

public final class SecurityUtil {
    private static final Logger LOGGER = LoggerFactory.getLogger(UserServiceImpl.class);

    public static Long getUserId() {
        LOGGER.info("GET AUTHENTICATION USER ID");

        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        Long id = null;
        if (authentication != null) {

            if (authentication.getPrincipal() instanceof UserDetails) {
                UserPrincipal userPrincipal = (UserPrincipal) authentication.getPrincipal();
                id = userPrincipal.getId();
            }

        }

        return id;
    }


}
