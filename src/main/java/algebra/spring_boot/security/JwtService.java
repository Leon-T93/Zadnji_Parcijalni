package algebra.spring_boot.security;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class JwtService {

    private final String SECRET_KEY = "n2$JolcYF/)G-]tPo$Un$~B(A0)B|]&ff,+!5fM?5BkUo@<XtS<Qj{{+|tZ0?4g^U";

    public boolean validateToken(String token, UserDetails userDetails) {
        String username = extractUsername(token);
        boolean isUsernameValid = username.equals(userDetails.getUsername());

        if (!isUsernameValid) {
            return false;
        }

        boolean isTokenExpired = checkIsTokenExpired(token);

        if (isTokenExpired) {
            return false;
        }

        return true;
    }

    private boolean checkIsTokenExpired(String token) {
        Date expirationDate = extractExpirationDate(token);
        boolean isExpired = expirationDate.before(new Date());
        return isExpired;
    }

    public Date extractExpirationDate (String token) {
        Claims allClaims = extractAllClaims(token);
        return allClaims.getExpiration();
    }


    public String extractUsername (String token) {
        Claims allClaims = extractAllClaims(token);
        return allClaims.getSubject();
    }

    private Claims extractAllClaims(String token) {
        return Jwts.parser()
                .setSigningKey(SECRET_KEY)
                .build()
                .parseClaimsJws(token)
                .getBody();
    }

    public String generateAccessToken(String subject) {
        return Jwts.builder()
                .setSubject(subject)
                .setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis() + 1000 * 60 * 60))
                .signWith(SignatureAlgorithm.HS256, SECRET_KEY)
                .compact();
    }

    public String generateRefreshToken(String subject){
        return Jwts.builder()
                .setSubject(subject)
                .setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis() + 1000* 60 *60 *100))
                .signWith(SignatureAlgorithm.HS256, SECRET_KEY)
                .compact();
    }
}
