package org.hzz.jwt;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.JwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import org.junit.Assert;
import org.junit.Test;
import javax.crypto.SecretKey;

/**
 * 解析token
 *
 * @author 胖卡
 * @version 1.0.0
 * @date 2024/5/29
 * @see GenerateJWT
 */
public class ParseJWT {
    //final String token = "eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJQYW5nS2EiLCJpYXQiOjE3MTY5OTc4NzYsImV4cCI6MTcxNzAwMTQ3Niwic2xvZ2FuIjoiTG92ZSBDb2RpbmciLCJyb2xlcyI6ImFkbWluIn0.RjNVFXwMjBi891xKyN_yncltUok4kvqV7ZDG_JpR_u4";
    final String token = "eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJQYW5nS2EiLCJpYXQiOjE3MTg3MDg1OTMsImV4cCI6MTcxODcwODU5Mywicm9sZXMiOiJhZG1pbiIsInNsb2dhbiI6IkxvdmUgQ29kaW5nIn0.IzVTNG57oBbHz-3UCIi5lDQi1qMYwlvN8WXZYmS5Ksg";
    final String key = "9cZjXN9uHH0erCgOAdZCsXIAJbeh7Q43eLa/c1a69rU=";

    @Test
    public void parse() {
        try {
            Claims payload = Jwts.parser()
                    .verifyWith(getSignKey())
                    .build()
                    .parseSignedClaims(token)
                    .getPayload();

            System.out.println(payload);
            System.out.println(payload.get("slogan"));
            System.out.println(payload.getSubject());
        } catch (JwtException ex) {
            System.out.println(ex);
        }

    }

    @Test
    public void subToken(){
        String tmp = "Bear "+token;
        System.out.println(tmp.substring(5));
        Assert.assertEquals(token,tmp.substring(5));
    }

    private SecretKey getSignKey() {
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