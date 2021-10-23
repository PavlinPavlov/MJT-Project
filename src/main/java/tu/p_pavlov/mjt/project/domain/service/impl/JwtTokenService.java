package tu.p_pavlov.mjt.project.domain.service.impl;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jws;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import tu.p_pavlov.mjt.project.domain.service.TokenService;

import javax.crypto.spec.SecretKeySpec;
import java.security.Key;
import java.util.Base64;

@Service
public class JwtTokenService implements TokenService {

    @Value("${security.jwt.secret.key}")
    private String secret;

    @Override
    public String extractUserId(String jwtToken) {
        Key hmacKey = new SecretKeySpec(
                Base64.getDecoder().decode(secret),
                SignatureAlgorithm.HS256.getJcaName()
        );

        Jws<Claims> jwt = Jwts.parserBuilder()
                .setSigningKey(hmacKey)
                .build()
                .parseClaimsJws(jwtToken);

        return jwt.getBody().get("id", String.class);
    }
}
