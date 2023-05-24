package com.vv.exception;

/**
 * @program: CourseVueProject
 * @description: 禁止异常
 * @author: kangwei
 * @create: 2023-04-22 21:40
 **/
public class ForbiddenException  extends RuntimeException{
    public ForbiddenException(String message) {
        super(message);
    }

}
