package com.vv.exception;

import com.vv.enums.ResEnum;
import com.vv.utils.ResUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.util.StringUtils;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * @program: CourseVueProject
 * @description: 统一拦截异常
 * @author: kangwei
 * @create: 2023-04-22 21:42
 **/
@Slf4j
@RestControllerAdvice
public class ExceptionAdvice {

    /**
     * @param exception
     * @return com.example.demo.response.Result<?>
     * @description 业务处理异常
     * @author kangwei
     * @date 2023-4-22
     */
    @ExceptionHandler({BusinessException.class})
    public ResUtils<?> handleBusinessException(BusinessException exception) {
        log.info("业务异常" + exception);
        return ResUtils.failed(exception.getMessage());
    }

    /**
     * 捕获 {@code ForbiddenException} 异常
     */
    @ExceptionHandler({ForbiddenException.class})
    public ResUtils<?> handleForbiddenException(ForbiddenException exception) {
        log.info("捕获异常" + exception);
        return ResUtils.failed(ResEnum.FORBIDDEN);
    }

    /**
     * @param exception
     * @return com.example.demo.response.Result<?>
     * @description 参数校验不通过时抛出的异常处理
     * @author kangwei
     * @date 2023-4-22
     */
    @ExceptionHandler({MethodArgumentNotValidException.class})
    public ResUtils<?> handleMethodArgumentNotValidException(MethodArgumentNotValidException exception) {
        BindingResult bindingResult = exception.getBindingResult();
        StringBuilder sb = new StringBuilder("校验失败:");
        for (FieldError fieldError : bindingResult.getFieldErrors()) {
            sb.append(fieldError.getField()).append("：").append(fieldError.getDefaultMessage()).append(", ");
        }
        String msg = sb.toString();
        if (StringUtils.hasText(msg)) {
            return ResUtils.failed(ResEnum.VALIDATE_FAILED.getCode(), msg);
        }
        return ResUtils.failed(ResEnum.VALIDATE_FAILED);
    }


    /**
     * @param ex
     * @return com.example.demo.response.Result<?>
     * @description 顶级异常捕获并统一处理，当其他异常无法处理时候选择使用
     * @author kangwei
     * @date 2023-4-22
     */
    @ExceptionHandler({Exception.class})
    public ResUtils<?> handle(Exception ex) {
        return ResUtils.failed(ex.getMessage());
    }

}
