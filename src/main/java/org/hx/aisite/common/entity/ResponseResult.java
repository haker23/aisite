package org.hx.aisite.common.entity;

import com.baomidou.mybatisplus.core.toolkit.ObjectUtils;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Builder;
import lombok.Data;
import org.hx.aisite.common.enums.ResponseCodeEnum;

import java.io.Serializable;

@Data
@Builder
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ResponseResult<T> implements Serializable {
    private Integer code;
    private String msg;
    private T data;


    public ResponseResult() {
        this.code = ResponseCodeEnum.SUCCESS.getCode();
        this.msg = ResponseCodeEnum.SUCCESS.getMsg();
    }

    public ResponseResult(Integer code, T data) {
        this.code = code;
        this.data = data;
    }

    public ResponseResult(Integer code, String msg, T data) {
        this.code = code;
        this.msg = msg;
        this.data = data;
    }

    public ResponseResult(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }


    public static ResponseResult okResult(){
        ResponseResult result = new ResponseResult();
        return result;
    }

    public static ResponseResult okResult(int code, String msg){
        ResponseResult result = new ResponseResult();
        return result.ok(code, msg, null);
    }

    public static ResponseResult okResult(Object data){
        ResponseResult result = setAppHttpCodeEnum(ResponseCodeEnum.SUCCESS, ResponseCodeEnum.SUCCESS.getMsg());
        if(ObjectUtils.isNotNull(data)){
            result.setData(data);
        }
        return result;
    }

    public static ResponseResult errorResult(int code, String msg){
        ResponseResult result = new ResponseResult();
        return result.error(code, msg);
    }

    public static ResponseResult errorResult(ResponseCodeEnum enums){
        ResponseResult result = setAppHttpCodeEnum(enums, enums.getMsg());
        return result;
    }

    public static ResponseResult errorResult(ResponseCodeEnum enums, String msg){
        ResponseResult result = setAppHttpCodeEnum(enums, msg);
        return result;
    }

    public static ResponseResult setAppHttpCodeEnum(ResponseCodeEnum enums){
        return okResult(enums.getCode(), enums.getMsg());
    }

    public static ResponseResult setAppHttpCodeEnum(ResponseCodeEnum enums, String msg){
        return okResult(enums.getCode(), msg);
    }


    public ResponseResult<?> error(Integer code, String msg){
        this.code = code;
        this.msg = msg;
        return this;
    }

    public ResponseResult<?> ok(Integer code, T data){
        this.code = code;
        this.data = data;
        return this;
    }

    public ResponseResult<?> ok(Integer code, String msg, T data){
        this.code = code;
        this.msg = msg;
        this.data = data;
        return this;
    }

    public ResponseResult<?> ok(T data){
        this.data = data;
        return this;
    }

}