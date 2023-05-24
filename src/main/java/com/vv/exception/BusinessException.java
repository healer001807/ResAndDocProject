package com.vv.exception;

/**
 * @program: CourseVueProject
 * @description: 业务异常
 * @author: kangwei
 * @create: 2023-04-22 21:41
 **/
public class BusinessException extends RuntimeException{
    public BusinessException(String message) {
        super(message);
    }
}
