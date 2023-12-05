package com.vv.exception;

import lombok.Getter;
import lombok.Setter;

/**
 * @program: CourseVueProject
 * @description: 业务异常
 * @author: kangwei
 * @create: 2023-04-22 21:41
 **/
@Setter
@Getter
public class BusinessException extends RuntimeException {

    private Integer code;
    private String msg;

    public BusinessException(String msg) {
        super(msg);
        this.msg = msg;
    }

    public BusinessException(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }
}
