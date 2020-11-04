package com.xschen.boot.launch;


import lombok.Data;

/**
 * @author xschen
 *
 * 统一规范接口响应的数据格式，
 * 作用是：统一所有开发人员响应前端请求的返回结果格式，减少前后端开发人员沟通成本，是一种RESTful接口标准化的开发约定。
 */

@Data
public class AjaxResponse {
    // 请求是否处理成功
    private boolean isok;
    // 请求响应状态码
    private int code;
    // 请求描述信息
    private String message;
    // 请求结果数据
    private Object data;

    // 请求成功的响应，不带查询数据（用于删除、修改，新增接口）
    public static AjaxResponse success() {
        AjaxResponse ajaxResponse = new AjaxResponse();
        ajaxResponse.setIsok(true);
        ajaxResponse.setCode(200);
        ajaxResponse.setMessage("success");
        return ajaxResponse;
    }

    // 请求成功的响应，带有查询数据（用于数据查询接口）
    public static AjaxResponse success(Object data) {
        AjaxResponse ajaxResponse = new AjaxResponse();
        ajaxResponse.setIsok(true);
        ajaxResponse.setCode(200);
        ajaxResponse.setMessage("success");
        ajaxResponse.setData(data);
        return ajaxResponse;
    }

    // 请求成功的响应，带有查询数据（用于数据查询接口）
    public static AjaxResponse success(Object data, String message) {
        AjaxResponse ajaxResponse = new AjaxResponse();
        ajaxResponse.setIsok(true);
        ajaxResponse.setCode(200);
        ajaxResponse.setMessage(message);
        ajaxResponse.setData(data);
        return ajaxResponse;
    }
}
