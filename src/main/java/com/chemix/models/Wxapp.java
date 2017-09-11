package com.chemix.models;

import org.springframework.data.annotation.Id;

/**
 * Created by chenshijue on 2017/9/11.
 */
public class Wxapp {

    @Id
    private String id;

    private String appid;

    private String appSecret;

    private String appName;

    private String remark;

    public Wxapp() {
    }

    public Wxapp(String appid, String appSecret, String appName, String remark) {
        this.appid = appid;
        this.appSecret = appSecret;
        this.appName = appName;
        this.remark = remark;
    }

    public Wxapp(String id, String appid, String appSecret, String appName, String remark) {
        this.id = id;
        this.appid = appid;
        this.appSecret = appSecret;
        this.appName = appName;
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

    public String getAppSecret() {
        return appSecret;
    }

    public void setAppSecret(String appSecret) {
        this.appSecret = appSecret;
    }

    public String getAppName() {
        return appName;
    }

    public void setAppName(String appName) {
        this.appName = appName;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }
}
