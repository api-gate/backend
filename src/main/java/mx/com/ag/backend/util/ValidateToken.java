package mx.com.ag.backend.util;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureException;
import mx.com.ag.exception.AGException;
import mx.com.ag.exception.messages.ExceptionCode;

import javax.ejb.Singleton;
import javax.ejb.Startup;

/**
 * @author Alejandro Luna
 * Date: 24/07/2018
 */
@Singleton
@Startup
public class ValidateToken {

    public void validateToken(String tkn) throws AGException {
        try {
            Jwts.parser().setSigningKey("1234").parseClaimsJws(tkn);
        } catch (SignatureException e) {
            throw new AGException(ExceptionCode.UNAUTHORIZED);
        }
    }
}
