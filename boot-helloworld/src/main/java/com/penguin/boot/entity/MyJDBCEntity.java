package com.penguin.boot.entity;


import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties(prefix = "myjdbc")
//predix不能有大写字母
public class MyJDBCEntity {
    private String username;
    private String password;
    private String driverClass;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getDriverClass() {
        return driverClass;
    }

    public void setDriverClass(String driverClass) {
        this.driverClass = driverClass;
    }

    @Override
    public String toString(){
        return "MyJDBCEntity{"+username+","+password+","+driverClass+"}";
    }
}


