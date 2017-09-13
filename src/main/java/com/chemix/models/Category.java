package com.chemix.models;

/**
 * Created by chenshijue on 2017/9/13.
 */
public class Category {

    private String id;

    private String name;

    private boolean select;

    public Category() {
    }

    public Category(String name, boolean select) {
        this.name = name;
        this.select = select;
    }

    public Category(String id, String name, boolean select) {
        this.id = id;
        this.name = name;
        this.select = select;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isSelect() {
        return select;
    }

    public void setSelect(boolean select) {
        this.select = select;
    }
}
