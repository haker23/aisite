package org.hx.aisite.common.advice;

import org.hx.aisite.common.entity.BizException;
import org.hx.aisite.common.entity.ResponseResult;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.servlet.http.HttpServletRequest;

@Order(Ordered.LOWEST_PRECEDENCE)
@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(value = BizException.class)
    @ResponseBody
    public ResponseResult<Object> bizExceptionHandler(HttpServletRequest req, BizException e) {
        return ResponseResult.errorResult(Integer.parseInt(String.valueOf(e.getErrorCode())), e.getErrorMsg());
    }
}
