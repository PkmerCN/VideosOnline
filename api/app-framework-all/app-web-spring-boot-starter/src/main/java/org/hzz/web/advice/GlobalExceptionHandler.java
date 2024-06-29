package org.hzz.web.advice;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.validation.ConstraintViolation;
import lombok.extern.slf4j.Slf4j;
import org.hzz.core.code.AppStatus;
import org.hzz.core.exception.AppCommonException;
import org.hzz.core.exception.arg.AppArgumentNotValidException;
import org.hzz.core.result.Result;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.*;
import java.util.stream.Collectors;

/**
 * @author 胖卡
 * @version 1.0.0
 * @date 2024/6/22
 */
@Slf4j
@RestControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {

    @Override
    protected ResponseEntity<Object> handleMissingServletRequestParameter(MissingServletRequestParameterException ex, HttpHeaders headers, HttpStatusCode status, WebRequest request) {
       log.info("{}参数绑定错误: {}",ex.getParameterName(),ex.getBody().getDetail());
        return new ResponseEntity<>(ex.getBody(), status);
    }

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

    /**
     * 处理手动校验的异常
     * @param ex 校验的结果封装
     */
    @ExceptionHandler(AppArgumentNotValidException.class)
    public Result<Map<String,String>> handleAppArgumentNotValidException(AppArgumentNotValidException ex){
        log.info("处理手动校验的异常");
        Set<? extends ConstraintViolation<?>> constraintViolationSet = ex.getConstraintViolationSet();

        Map<String,String> body = new HashMap<>();
        for (ConstraintViolation<?> c: constraintViolationSet){
            body.put(c.getPropertyPath().toString(),c.getMessage());
        }

        return Result.error(body,ex.getStatus().code(),ex.getStatus().getReason());
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