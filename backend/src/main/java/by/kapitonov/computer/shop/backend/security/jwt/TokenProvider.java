package by.kapitonov.computer.shop.backend.security.jwt;

import by.kapitonov.computer.shop.backend.security.UserPrincipal;
import io.jsonwebtoken.*;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class TokenProvider {
    private static final Logger LOGGER = Logger.getLogger(TokenProvider.class);

    @Value("${jwt.security.key}")
    private String securityKey;

    @Value("${jwt.security.expired}")
    private Long expired;

    public String generateToken(Authentication authentication) {

        UserPrincipal userPrincipal = (UserPrincipal) authentication.getPrincipal();

        Date now = new Date();
        Date expiration = new Date(now.getTime() + expired);

        return Jwts.builder()
                .setExpiration(expiration)
                .setIssuedAt(now)
                .setSubject(userPrincipal.getUsername())
                .signWith(SignatureAlgorithm.HS256, securityKey)
                .compact();
    }

    public String getUsernameByToken(String token) {
        return Jwts.parser()
                .setSigningKey(securityKey)
                .parseClaimsJws(token)
                .getBody()
                .getSubject();
    }

    public boolean validateToken(String authToken) {
        try {
            Jwts.parser().setSigningKey(securityKey).parseClaimsJws(authToken);
            return true;
        } catch (SignatureException ex) {
            LOGGER.error("Invalid JWT signature");
        } catch (MalformedJwtException ex) {
            LOGGER.error("Invalid JWT token");
        } catch (ExpiredJwtException ex) {
            LOGGER.error("Expired JWT token");
        } catch (UnsupportedJwtException ex) {
            LOGGER.error("Unsupported JWT token");
        } catch (IllegalArgumentException ex) {
            LOGGER.error("JWT claims string is empty.");
        }
        return false;
    }

}
