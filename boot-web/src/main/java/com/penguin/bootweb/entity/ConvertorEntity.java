package com.penguin.bootweb.entity;

public class ConvertorEntity {
    private String fname;
    private String lname;
    private ConvertorRefEntity convertorRefEntity;

    public ConvertorRefEntity getConvertorRefEntity() {
        return convertorRefEntity;
    }

    public void setConvertorRefEntity(ConvertorRefEntity convertorRefEntity) {
        this.convertorRefEntity = convertorRefEntity;
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


