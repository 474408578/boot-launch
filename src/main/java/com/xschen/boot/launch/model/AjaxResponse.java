package com.xschen.boot.launch.model;

import lombok.Data;

/**
 * @author xschen
 *
 * 统一规范接口响应的数据格式，
 * 作用是：统一所有开发人员响应前端请求的返回结果格式，减少前后端开发人员沟通成本，是一种RESTful接口标准化的开发约定。
 */

@Data
public class AjaxResponse {
    private boolean isok;
    private int code;
    private String message;
    private Object data;

    private AjaxResponse() {}

    // 请求成功的响应，不带查询数据（用于删除、修改，新增接口）
    public static AjaxResponse success() {
        AjaxResponse resultBean = new AjaxResponse();
        resultBean.setIsok(true);
        resultBean.setCode(200);
        resultBean.setMessage("success");

        return resultBean;
    }

    // 请求成功的响应，带有查询数据（用于数据查询接口）
    public static AjaxResponse success(Object data) {
        AjaxResponse resultBean = new AjaxResponse();
        resultBean.setIsok(true);
        resultBean.setCode(200);
        resultBean.setMessage("success");
        resultBean.setData(data);

        return resultBean;
    }

    // 请求成功的响应，带有查询数据（用于数据查询接口）
    public static AjaxResponse success(Object data, String message) {
        AjaxResponse resultBean = new AjaxResponse();
        resultBean.setIsok(true);
        resultBean.setCode(200);
        resultBean.setMessage(message);
        resultBean.setData(data);

        return resultBean;
    }
}
