package mx.com.ag.backend.api.service;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.impl.crypto.MacProvider;
import mx.com.ag.backend.api.model.dto.AuthenticationRequest;
import mx.com.ag.exception.AGException;
import mx.com.ag.exception.messages.ExceptionCode;

import javax.ejb.Stateless;
import java.security.Key;
import java.util.UUID;

/**
 * @author Alex79L
 */
@Stateless
public class AuthenticationService {

    public String validateUser(AuthenticationRequest request) throws AGException {
        if (!request.getUsername().equals("aluna") && !request.getUsername().equals("Qwerty123@")) {
            throw new AGException(ExceptionCode.UNAUTHORIZED);
        }
        Key key = MacProvider.generateKey();
        return Jwts.builder()
                .setSubject(request.getUsername())
                .claim("userIdentifier", UUID.randomUUID().toString())
                .signWith(SignatureAlgorithm.HS512, "1234")
                .compact();
    }

}
