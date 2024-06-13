package org.hzz.services;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import org.hzz.config.AppProps;
import org.hzz.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import javax.crypto.SecretKey;
import java.security.Key;
import java.util.Date;
import java.util.Map;
import java.util.function.Function;

/**
 * @author 胖卡
 * @version 1.0.0
 * @date 2024/6/12
 */
@Service
public class JWTService {

  private final long expirationTime;
  private final String secretKey;

   public JWTService(AppProps appProps){
       secretKey = appProps.getJwt().getSecretKey();
       expirationTime = appProps.getJwt().getExpirationTime();
   }


    /**
     * 生成token
     * @return
     */
    public String generateToken(User user){
        Map<String, ?> extraClaims = Map.of("id",user.getId(),"email",user.getEmail());

        return Jwts.builder()
                .subject(user.getUsername())
                .issuedAt(new Date(System.currentTimeMillis()))
                .expiration(new Date(System.currentTimeMillis() + expirationTime))
                .claims(extraClaims)
                .signWith(getSignInKey())
                .compact();
    }


    public String extractUsername(String token){
        return extractClaim(extractAllClaims(token),Claims::getSubject);
    }

    private <T> T extractClaim(Claims claims, Function<Claims,T> claimResolver){
        return claimResolver.apply(claims);
    }

    /**
     * 解析错误会默认抛出一个JWTException是一个RuntimeException
     * @param token
     * @return
     */
    private Claims extractAllClaims(String token){
        return Jwts.parser()
                .verifyWith(getSignInKey())
                .build()
                .parseSignedClaims(token)
                .getPayload();
    }


    private SecretKey getSignInKey(){
        // 这里的key是A Base64-encoded string
        byte[] keyBytes = Decoders.BASE64.decode(secretKey);
        return Keys.hmacShaKeyFor(keyBytes);
    }

}
