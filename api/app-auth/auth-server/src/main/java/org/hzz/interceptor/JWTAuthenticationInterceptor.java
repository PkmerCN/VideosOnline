package org.hzz.interceptor;

import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.JwtException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.hzz.context.AppContextHolder;
import org.hzz.domain.user.bo.UserBo;
import org.hzz.exceptions.auth.AppTokenExpireException;
import org.hzz.exceptions.auth.AppTokenInvalidException;
import org.hzz.services.JWTService;
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
                AppContextHolder.userContextHolder.setUser(userBo);
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
