package org.hzz.exceptions;

import jakarta.servlet.http.HttpServletRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.Map;

/**
 * @author 胖卡
 * @version 1.0.0
 * @date 2024/6/12
 */
@Slf4j
@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(RuntimeException.class)
    public ResponseEntity<Map<String,Object>> handleRuntimeException(HttpServletRequest request, Exception ex) throws Exception {
        log.info("抓到了没有,{}",ex.getMessage());
        checkBrowser(request,ex);
        Map<String,Object> body = Map.of("message",ex.getMessage());
        return new ResponseEntity<>(body, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    private void checkBrowser(HttpServletRequest request,Exception ex) throws Exception {
        String accept = request.getHeader("Accept");
        // 如果是浏览器请求，我们直接抛出异常，交给BasicErrorController处理
        if(accept != null && accept.contains("text/html")){
            throw ex;
        }
    }
}
