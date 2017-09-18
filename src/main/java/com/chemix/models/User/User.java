package com.chemix.models.User;

import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;

/**
 * Created by chenshijue on 2017/9/13.
 */
public class User {

    @Id
    private String id;

    private String openid;

    private String mobile;

    private String type;

    private String province;

    private String lastPush;

    private Category interestingCategory;

    private WxInfo wxInfo;

    @Transient
    private String jwt;

    private String remark;

    public User() {
    }

    public User(String openid, String mobile, String type, String province, String lastPush, String remark) {
        this.openid = openid;
        this.mobile = mobile;
        this.type = type;
        this.province = province;
        this.lastPush = lastPush;
        this.remark = remark;
    }

    public User(String id, String openid, String mobile, String type, String province, String lastPush, String remark) {
        this.id = id;
        this.openid = openid;
        this.mobile = mobile;
        this.type = type;
        this.province = province;
        this.lastPush = lastPush;
        this.remark = remark;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getOpenid() {
        return openid;
    }

    public void setOpenid(String openid) {
        this.openid = openid;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public String getLastPush() {
        return lastPush;
    }

    public void setLastPush(String lastPush) {
        this.lastPush = lastPush;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public Category getInterestingCategory() {
        return interestingCategory;
    }

    public void setInterestingCategory(Category interestingCategory) {
        this.interestingCategory = interestingCategory;
    }

    public WxInfo getWxInfo() {
        return wxInfo;
    }

    public void setWxInfo(WxInfo wxInfo) {
        this.wxInfo = wxInfo;
    }

    public String getJwt() {
        return jwt;
    }

    public void setJwt(String jwt) {
        this.jwt = jwt;
    }
}
