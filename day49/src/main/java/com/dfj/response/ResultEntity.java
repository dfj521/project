package com.dfj.response;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * 统一用响应实体类封装controller给前台做出的响应
 */
@JsonIgnoreProperties({"data"})
public class ResultEntity {
    //1.状态码 0代表成功 非0代表失败
    private Integer status;
    //2.消息 来自后台的错误信息
    private String message;
    //3.数据 来自后台的数据
    //忽略Json序列化后传输的null值
    //@JsonIgnore
    private Object data;

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }
}
