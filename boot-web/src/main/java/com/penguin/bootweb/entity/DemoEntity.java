package com.penguin.bootweb.entity;

public class DemoEntity {
    private String fname;
    private String lname;
    private DemoRefEntity demoRefEntity;

    public DemoRefEntity getDemoRefEntity() {
        return demoRefEntity;
    }

    public void setDemoRefEntity(DemoRefEntity demoRefEntity) {
        this.demoRefEntity = demoRefEntity;
    }

    public String getFname() {
        return fname;
    }

    public void setFname(String fname) {
        this.fname = fname;
    }

    public String getLname() {
        return lname;
    }

    public void setLname(String lname) {
        this.lname = lname;
    }
}


