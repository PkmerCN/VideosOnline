package org.hzz.jwt;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import org.junit.Test;

import javax.crypto.SecretKey;

/**
 * 解析token
 * @see GenerateJWT
 * @author 胖卡
 * @version 1.0.0
 * @date 2024/5/29
 */
public class ParseJWT {
    final String token = "eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJQYW5nS2EiLCJpYXQiOjE3MTY5OTc4NzYsImV4cCI6MTcxNzAwMTQ3Niwic2xvZ2FuIjoiTG92ZSBDb2RpbmciLCJyb2xlcyI6ImFkbWluIn0.RjNVFXwMjBi891xKyN_yncltUok4kvqV7ZDG_JpR_u4";
    final String key =  "9cZjXN9uHH0erCgOAdZCsXIAJbeh7Q43eLa/c1a69rU=";
    @Test
    public void parse(){
        Claims payload = Jwts.parser()
                .verifyWith(getSignKey())
                .build()
                .parseSignedClaims(token)
                .getPayload();

        System.out.println(payload);
        System.out.println(payload.get("slogan"));
        System.out.println(payload.getSubject());
    }

    private SecretKey getSignKey(){
        // 这里的key是A Base64-encoded string
        byte[] keyBytes = Decoders.BASE64.decode(key);
        return Keys.hmacShaKeyFor(keyBytes);
    }
}
/**
 * {sub=PangKa, iat=1716997876, exp=1717001476, slogan=Love Coding, roles=admin}
 * Love Coding
 * PangKa
 */