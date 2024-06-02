package org.hzz.jwt;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.impl.Base64Codec;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import io.jsonwebtoken.security.SecureDigestAlgorithm;
import lombok.extern.slf4j.Slf4j;
import org.junit.Before;
import org.junit.Test;

import java.security.Key;
import java.time.LocalDate;
import java.util.Date;
import java.util.Map;

import static io.jsonwebtoken.Jwts.*;

/**
 * JWT练习：生成token和验证
 *
 * @author 胖卡
 * @version 1.0.0
 * @date 2024/5/29
 */
@Slf4j
public class GenerateJWT {
    String key;
    long expirationTime;
    @Before
    public void beforeGenerateKey() {
        // https://www.devglan.com/online-tools/hmac-sha256-online
        // 用SHA-256 加密的SecretKey 123 输出base64格式
        key = "9cZjXN9uHH0erCgOAdZCsXIAJbeh7Q43eLa/c1a69rU=";
        // 1h in millisecond
        expirationTime = 3600000;
    }

    @Test
    public void generateToken() {
        Map<String, ?> extraClaims = Map.of("roles", "admin",
                "slogan", "Love Coding");

        String token = builder()
                .header()
                .type("JWT").and()
                .subject("PangKa")
                .issuedAt(new Date(System.currentTimeMillis()))
                .expiration(new Date(System.currentTimeMillis() + expirationTime))
                .claims(extraClaims)
                .signWith(getSignInKey())
                .compact();
        System.out.println(token);
        //三部分的base64解密
        System.out.println("============================================");
        String[] split = token.split("\\.");
        System.out.println(Base64Codec.BASE64.decodeToString(split[0]));
        System.out.println(Base64Codec.BASE64.decodeToString(split[1]));
        //无法解密
        //System.out.println(Base64Codec.BASE64.decodeToString(split[2]));
    }
    /**output
     * eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJzbG9nYW4iOiJMb3ZlIENvZGluZyIsInJvbGVzIjoiYWRtaW4ifQ.Vjab0Ta8i6Jewpd42bT_X4CsLVEVS-ZU77UBMhR9djU
     * ============================================
     * {"typ":"JWT","alg":"HS256"}
     * {"slogan":"Love Coding","roles":"admin"}
     */

    private Key getSignInKey(){
        // 这里的key是A Base64-encoded string
        byte[] keyBytes = Decoders.BASE64.decode(key);
        return Keys.hmacShaKeyFor(keyBytes);
    }
}
