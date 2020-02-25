package de.virtuos.empresa.security;

import java.util.Date;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTVerificationException;
import com.auth0.jwt.interfaces.JWTVerifier;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Component;

@Component
public class JwtUtils {
    private static final Logger logger = LoggerFactory.getLogger(JwtUtils.class);

    @Value("${empresa.app.jwtSecret}")
    private String jwtSecret;

    @Value("${empresa.app.jwtExpirationMs}")
    private int jwtExpirationMs;

    private Algorithm algorithm;
    private JWTVerifier tokenVerifier;

    public String generateJwtToken(Authentication authentication) {

        UserDetailsImpl userPrincipal = (UserDetailsImpl) authentication.getPrincipal();

        return JWT.create()
                .withSubject((userPrincipal.getUsername()))
                .withIssuedAt(new Date())
                .withExpiresAt(new Date((new Date()).getTime() + jwtExpirationMs))
                .sign(getAlgorithm());


        /*return Jwts.builder()
                .setSubject((userPrincipal.getUsername()))
                .setIssuedAt(new Date())
                .setExpiration()
                .signWith(SignatureAlgorithm.HS512, jwtSecret)
                .compact();*/
    }

    public String getUserNameFromJwtToken(String token) {
        return JWT.decode(token).getSubject();
    }

    public boolean validateJwtToken(String token) {
        try {
            getTokenVerifier().verify(token);
            return true;
        } catch (JWTVerificationException e){
            logger.error("JWT token couldn't be verified", e);
        }
        return false;
    }

    private JWTVerifier getTokenVerifier() {
        if(tokenVerifier == null) {
            tokenVerifier = JWT.require(getAlgorithm()).build();
        }
        return tokenVerifier;
    }

    private Algorithm getAlgorithm() {
        if(algorithm == null) algorithm = Algorithm.HMAC512(jwtSecret);
        return algorithm;
    }

}
