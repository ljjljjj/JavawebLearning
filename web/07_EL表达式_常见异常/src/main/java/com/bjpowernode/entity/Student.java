package com.bjpowernode.entity;

public class Student {
    private Integer sid;
    private String sName;

    public Integer getSid() {
        return sid;
    }

    public void setSid(Integer sid) {
        this.sid = sid;
    }

    public String getsName() {
        return sName;
    }

    public void setsName(String sName) {
        this.sName = sName;
    }

    public Student(Integer sid, String sName) {
        this.sid = sid;
        this.sName = sName;
    }

    public Student() {
    }
}
