package org.hzz.mvc.advice;

import jakarta.servlet.http.HttpServletRequest;
import lombok.extern.slf4j.Slf4j;
import org.hzz.domain.app.AppStatus;
import org.hzz.domain.app.Result;
import org.hzz.exceptions.AppCommonException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.*;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.Date;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @author 胖卡
 * @version 1.0.0
 * @date 2024/6/12
 */
@Slf4j
@RestControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {

    /**
     * 参数校验异常
     */
    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException exception, HttpHeaders headers, HttpStatusCode status, WebRequest request) {
        log.info("校验失败");
        Map<String, Object> objectBody = new LinkedHashMap<>();
        objectBody.put("Current Timestamp", new Date());
        objectBody.put("Status", status.value());

        // Get all errors
        List<String> exceptionalErrors = exception.getBindingResult()
                .getFieldErrors()
                .stream()
                .map(x -> x.getField()+":"+x.getDefaultMessage())
                .collect(Collectors.toList());

        objectBody.put("Errors", exceptionalErrors);

        return new ResponseEntity<>(objectBody, status);
    }



    @ExceptionHandler(AppCommonException.class)
    public Result<String> handleAppException(HttpServletRequest request, AppCommonException ex) throws Exception {
        AppStatus appStatus = ex.getStatus();
        log.info("自定义异常 -> {} , 状态码：{}, 异常原因：{} ",ex.getClass().getName(),appStatus.code(),appStatus.getReason());
        checkBrowser(request,ex);
        return Result.error(appStatus);
    }

    @ExceptionHandler(RuntimeException.class)
    public Result<String> handleRuntimeException(HttpServletRequest request, RuntimeException ex) throws Exception {
        log.error("其他异常 uri : {} -> {}", request.getRequestURI(),ex.getMessage());
        checkBrowser(request,ex);
        return Result.error(ex.getMessage());
    }

    private void checkBrowser(HttpServletRequest request,Exception ex) throws Exception {
        String accept = request.getHeader("Accept");
        String method = request.getMethod();

        // 如果是浏览器请求，我们直接抛出异常，交给BasicErrorController处理
        if( "GET".equalsIgnoreCase(method) && (accept != null && accept.contains("text/html"))){
            log.info("交给error处理html");
            throw ex;
        }
    }
}