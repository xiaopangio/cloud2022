package com.xiaobai.springcloud.entity.result;

import lombok.Getter;

/**
 * className: ResultCode
 * description:
 * author: xiaopangio
 * date: 2022/9/3 17:12
 * version: 1.0
 */
@Getter
public enum ResultCode implements StatusCode{
    SUCCESS(200, "请求成功"),
    FAIL(400, "请求失败"),
    VALIDATE_FAILED(406, "参数检验失败"),
    NOT_FOUND(404, "未找到该资源"),
    RESPONSE_FAILED(500, "响应失败"),;
    private int code;
    private String message;
    ResultCode(int code, String message) {
        this.code = code;
        this.message = message;
    }
}
