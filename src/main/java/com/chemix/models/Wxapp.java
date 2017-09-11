package com.chemix.models;

import org.springframework.data.annotation.Id;

/**
 * Created by chenshijue on 2017/9/11.
 */
public class Wxapp {

    @Id
    private String id;

    private String appid;

    private String app_secret;

    private String app_name;

    private String remark;

    public Wxapp() {
    }

    public Wxapp(String appid, String app_secret, String app_name, String remark) {
        this.appid = appid;
        this.app_secret = app_secret;
        this.app_name = app_name;
        this.remark = remark;
    }

    public Wxapp(String id, String appid, String app_secret, String app_name, String remark) {
        this.id = id;
        this.appid = appid;
        this.app_secret = app_secret;
        this.app_name = app_name;
        this.remark = remark;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getAppid() {
        return appid;
    }

    public void setAppid(String appid) {
        this.appid = appid;
    }

    public String getApp_secret() {
        return app_secret;
    }

    public void setApp_secret(String app_secret) {
        this.app_secret = app_secret;
    }

    public String getApp_name() {
        return app_name;
    }

    public void setApp_name(String app_name) {
        this.app_name = app_name;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }
}
