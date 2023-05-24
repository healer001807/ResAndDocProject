package com.vv.enums;

import com.vv.utils.IResult;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

/**
 * @program: ResAndDocProject
 * @description: 响应枚举
 * @author: kangwei
 * @create: 2023-05-24 14:40
 **/
@NoArgsConstructor
@AllArgsConstructor
public enum ResEnum implements IResult {

    SUCCESS(2001, "接口调用成功"),
    VALIDATE_FAILED(2002, "参数校验失败"),
    COMMON_FAILED(2003, "接口调用失败"),
    FORBIDDEN(2004, "没有权限访问资源");


    private Integer code;
    private String msg;


    public void setCode(Integer code) {
        this.code = code;
    }

    @Override
    public Integer getCode() {
        return code;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    @Override
    public String getMsg() {
        return msg;
    }
}
