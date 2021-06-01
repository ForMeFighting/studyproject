package com.chai.servicebase.utilbo;

import java.util.List;

public class TreeData {
    private String id;
    private String name;
    private String pId;
    private List<TreeData> child;

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

    public String getpId() {
        return pId;
    }

    public void setpId(String pId) {
        this.pId = pId;
    }

    public List<TreeData> getChild() {
        return child;
    }

    public void setChild(List<TreeData> child) {
        this.child = child;
    }

    @Override
    public String toString() {
        return "TreeData{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", pId='" + pId + '\'' +
                ", child=" + child +
                '}';
    }
}