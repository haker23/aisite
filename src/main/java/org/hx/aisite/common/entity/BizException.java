package org.hx.aisite.common.entity;

import lombok.Data;

/**
 * 自定义异常类
 *
 * @return
 * @date 2024/6/13 11:09
 **/
@Data
public class BizException extends RuntimeException {

    private static final long serialVersionUID = 1L;

    /**
     * 错误码
     */
    protected int errorCode;
    /**
     * 错误信息
     */
    protected String errorMsg;

    public BizException() {
        super();
    }

    public BizException(ResponseResult bizException) {
        super(String.valueOf(bizException.getCode()));
        this.errorCode = bizException.getCode();
        this.errorMsg = bizException.getMsg();
    }

    public BizException(ResponseResult bizException, Throwable cause) {
        super(String.valueOf(bizException.getCode()), cause);
        this.errorCode = bizException.getCode();
        this.errorMsg = bizException.getMsg();
    }

    public BizException(String errorMsg) {
        super(errorMsg);
        this.errorMsg = errorMsg;
    }

    public BizException(int errorCode, String errorMsg) {
        super(String.valueOf(errorCode));
        this.errorCode = errorCode;
        this.errorMsg = errorMsg;
    }

    public BizException(int errorCode, String errorMsg, Throwable cause) {
        super(String.valueOf(errorCode), cause);
        this.errorCode = errorCode;
        this.errorMsg = errorMsg;
    }

    @Override
    public Throwable fillInStackTrace() {
        return this;
    }

}
