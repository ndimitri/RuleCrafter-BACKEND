package be.storm.rulecrafterbackend.il.utils;

import be.storm.rulecrafterbackend.dl.entities.user.User;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.JwtBuilder;
import io.jsonwebtoken.JwtParser;
import io.jsonwebtoken.Jwts;
import org.springframework.stereotype.Component;

import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import java.util.Date;

@Component
public class JwtUtils {

    private static final String SECRET = "Constantinopleeeeeeeeeeeeeeeeeeeeeeeeee";
    private static final long EXPIRATION_TIME = 86400L;

    private final JwtBuilder jwtBuilder;
    private final JwtParser jwtParser;

    public JwtUtils() {
        SecretKey secretKey = new SecretKeySpec(SECRET.getBytes(), "HmacSHA256");
        this.jwtBuilder = Jwts.builder().signWith(secretKey);
        this.jwtParser = Jwts.parserBuilder().setSigningKey(secretKey).build();
    }

    public String generateToken(User user) {

        return this.jwtBuilder
                .setSubject(user.getUsername())
                .setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis() + EXPIRATION_TIME * 1000))
                .compact();
    }

    private Claims parseToken(String token) {

        return this.jwtParser.parseClaimsJws(token).getBody();
    }

    public String getUsername(String token) {
        return parseToken(token).getSubject();
    }

    public boolean isValid(String token) {
        Claims claims = parseToken(token);
        Date now = new Date();

        return now.after(claims.getIssuedAt()) && now.before(claims.getExpiration());
    }


}
