package com.chemix.libs.controller;


import java.util.HashMap;

/**
 * Created by chenshijue on 2017/9/8.
 */
public class BaseController {

    public class Result extends HashMap<String, Object> {
    }

    protected Result _true(){
        Result result = new Result();
        result.put("result", "TRUE");
        return result;
    }

    protected Result _true(Object data){
        Result result = new Result();
        result.put("result", "TRUE");
        result.put("data", data);
        return result;
    }

    protected Result _false(String errorCode){
        Result result = new Result();
        result.put("result", "FALSE");
        result.put("errorcode", errorCode);
        return result;
    }

    protected Result _false(String errorCode, String errorMsg){
        Result result = new Result();
        result.put("result", "FALSE");
        result.put("errorcode", errorCode);
        result.put("msg", errorMsg);
        return result;
    }

    protected Result _falseParam(){
        Result result = new Result();
        result.put("result", "FALSE");
        result.put("errorcode", "70003");
        result.put("msg", "Some params no value");
        return result;
    }

}
