package com.vv.utils;

import com.vv.enums.ResEnum;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @program: ResAndDocProject
 * @description: 响应信息
 * @author: kangwei
 * @create: 2023-05-24 14:39
 **/

@Schema(name = "ResUtils", description = "返回响应信息")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ResUtils<T> {
    @Schema(name = "code", description = "响应码值")
    private Integer code;
    @Schema(name = "message", description = "响应信息")
    private String msg;
    @Schema(name = "data", description = "响应体")
    private T data;

    /***
     * @description
     * @param []
     * @return com.vv.utils.ResUtils<T>
     * @author
     * @date 2023/5/28
     **/


    public static <T> ResUtils<T> success() {
        return new ResUtils<T>(ResEnum.SUCCESS.getCode(), ResEnum.SUCCESS.getMsg());
    }

    /***
     * @description 消息
     * @param [msg]
     * @return com.vv.utils.ResUtils<T>
     * @author
     * @date 2023/5/28
     **/

    public static <T> ResUtils<T> success(String msg) {

        return new ResUtils<T>(ResEnum.SUCCESS.getCode(), msg);
    }


    /**
     * 接口调用成功：返回数据
     *
     * @param data
     * @param <T>
     * @return
     */
    public static <T> ResUtils<T> success(T data) {
        return new ResUtils<T>(ResEnum.SUCCESS.getCode(), ResEnum.SUCCESS.getMsg(), data);
    }

    /***
     * @description
     * @author kangwei
     * @date 2023-5-24
     * @param [code, msg]
     @return com.vv.utils.ResUtils<T>
     */
    public static <T> ResUtils<T> success(Integer code, String msg) {

        return new ResUtils<T>(code, msg);
    }

    /**
     * 接口调用成功：根据响应
     *
     * @param msg
     * @param data
     * @param <T>
     * @return
     */
    public static <T> ResUtils<T> success(String msg, T data) {
        return new ResUtils<T>(ResEnum.SUCCESS.getCode(), msg, data);

    }


    /***
     * @description
     * @author kangwei
     * @date 2023-5-24
     * @param [code, msg, data]
     @return com.vv.utils.ResUtils<T>
     */
    public static <T> ResUtils<T> success(Integer code, String msg, T data) {

        return new ResUtils<T>(code, msg, data);
    }

    /***
     * @description
     * @author kangwei
     * @date 2023-5-24
     * @param []
     @return com.vv.utils.ResUtils<?>
     */
    public static ResUtils<?> failed() {
        return new ResUtils<>(ResEnum.COMMON_FAILED.getCode(), ResEnum.COMMON_FAILED.getMsg(), null);
    }

    /***
     * @description
     * @author kangwei
     * @date 2023-5-24
     * @param [code, message]
     @return com.vv.utils.ResUtils<?>
     */
    public static <T> ResUtils<T> failed(Integer code, String msg) {
        return new ResUtils<>(code, msg);
    }

    /***
     * @description
     * @author kangwei
     * @date 2023-5-24
     * @param [message]
     @return com.vv.utils.ResUtils<?>
     */
    public static <T> ResUtils<T> failed(String msg) {
        return new ResUtils<>(ResEnum.COMMON_FAILED.getCode(), msg, null);
    }


    /***
     * @description
     * @author kangwei
     * @date 2023-5-24
     * @param [errorResult]
     @return com.vv.utils.ResUtils<?>
     */
    public static <T> ResUtils<T> failed(IResult errorResult) {
        return new ResUtils<>(errorResult.getCode(), errorResult.getMsg(), null);
    }

    /***
     * @description
     * @author kangwei
     * @date 2023-5-24
     * @param [code, message, data]
     @return com.vv.utils.ResUtils<T>
     */
    public static <T> ResUtils<T> instance(Integer code, String message, T data) {
        ResUtils<T> resUtils = new ResUtils<>();
        resUtils.setCode(code);
        resUtils.setMsg(message);
        resUtils.setData(data);
        return resUtils;
    }

    ResUtils(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }

}
