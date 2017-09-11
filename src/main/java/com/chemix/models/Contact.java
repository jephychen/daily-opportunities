package com.chemix.models;

/**
 * Created by chenshijue on 2017/9/11.
 */
public class Contact {
    private String name;

    private String mobile;

    public Contact() {
    }

    public Contact(String name, String mobile) {
        this.name = name;
        this.mobile = mobile;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }
}
