package com.xiaobai.springcloud.entity.result;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * className: CommonResult
 * description:
 * author: xiaopangio
 * date: 2022/9/3 17:15
 * version: 1.0
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class CommonResult <T>{
    private int code;
    private String message;
    private T data;
    //默认返回成功状态码，数据对象
    public CommonResult(T data){
        this.code=ResultCode.SUCCESS.getCode();
        this.message=ResultCode.SUCCESS.getMessage();
        this.data=data;
    }
    //返回指定状态码，数据对象
    public CommonResult(StatusCode statusCode,T data){
        this.code=statusCode.getCode();
        this.message=statusCode.getMessage();
        this.data=data;
    }
    //只返回状态码，不返回数据对象
    public CommonResult(StatusCode statusCode){
        this.code=statusCode.getCode();
        this.message=statusCode.getMessage();
        this.data=null;
    }
}
