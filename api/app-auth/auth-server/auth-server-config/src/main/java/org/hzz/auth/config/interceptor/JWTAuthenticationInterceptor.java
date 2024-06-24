package org.hzz.auth.config.interceptor;

import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.JwtException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.hzz.auth.config.exception.AppTokenExpireException;
import org.hzz.auth.config.exception.AppTokenInvalidException;

import org.hzz.security.context.AppContextHolder;
import org.hzz.security.jwt.bo.JWTUserBo;
import org.hzz.security.jwt.service.JWTService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.HandlerInterceptor;

import static org.hzz.security.jwt.constants.JWTConstants.*;

/**
 * @author 胖卡
 * @version 1.0.0
 * @date 2024/6/22
 */
public class JWTAuthenticationInterceptor implements HandlerInterceptor {
    private final Logger logger = LoggerFactory.getLogger(JWTAuthenticationInterceptor.class);

    private final JWTService jwtService;

    public JWTAuthenticationInterceptor(JWTService jwtService) {
        this.jwtService = jwtService;
    }

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        final String header = request.getHeader(AUTHORIZATION_HEADER);
        if (header != null && header.startsWith(OAUTH2_Bear)) {
            String token = header.substring(OAUTH2_PREFIX_SIZE);
            logger.info("Token = {}", token);
            try {
                JWTUserBo jwtUserBo = jwtService.parseToken(token);
                AppContextHolder.userContextHolder.setUser(jwtUserBo);
            } catch (ExpiredJwtException ex) {
                logger.info("token已过期");
                throw new AppTokenExpireException();
            } catch (JwtException ex) {

                logger.info("request = {} token不合法",request.getRequestURI());
                throw new AppTokenInvalidException();
            }
        } else {
            logger.info("request = {} no token",request.getRequestURI());
            throw new AppTokenInvalidException();
        }
        return true;
    }

    /**
     * 确保每个线程在处理完请求后能够清理其 ThreadLocal 存储的用户信息，以防止内存泄漏和数据污染。
     * 每个HTTP请求在Spring框架中通常是由线程池中的线程处理的，这些线程可能会被重用以处理后续的请求。
     * 如果不清理 ThreadLocal 中的数据，后续请求可能会访问到之前请求的用户信息，这会导致数据混乱和潜在的安全问题。
     */
    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        AppContextHolder.userContextHolder.clear();
    }
}
