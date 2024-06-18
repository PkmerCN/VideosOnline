package org.hzz.interceptor;

import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.JwtException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.hzz.domain.bo.UserBo;
import org.hzz.exceptions.auth.AppTokenExpireException;
import org.hzz.exceptions.auth.AppTokenInvalidException;
import org.hzz.services.JWTService;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.servlet.HandlerInterceptor;

/**
 * @author 胖卡
 * @version 1.0.0
 * @date 2024/6/12
 */
@Slf4j
public class JWTAuthenticationInterceptor implements HandlerInterceptor {

    private JWTService jwtService;

    public JWTAuthenticationInterceptor(JWTService jwtService) {
        this.jwtService = jwtService;
    }

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        final String header = request.getHeader("Authorization");
        if (header != null && header.startsWith("Bear ")) {
            String token = header.substring(5);
            log.info("Token = {}", token);
            try {
                UserBo userBo = jwtService.parseToken(token);
            } catch (ExpiredJwtException ex) {
                log.info("token已过期");
                throw new AppTokenExpireException();
            } catch (JwtException ex) {
                log.info("token不合法");
                throw new AppTokenInvalidException();
            }

        } else {
            log.info("no token");
        }


        // todo 就是如何确认token是否过期
        return true;
    }
}
