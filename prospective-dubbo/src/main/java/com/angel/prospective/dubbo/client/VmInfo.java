package com.angel.prospective.dubbo.client;

import java.io.Serializable;

/**
 * @author wanbf
 * @date 2019/2/26 9:58
 */
public class VmInfo implements Serializable {
    private String id;
    private String name;
    private String ip;
    private String userName;
    private String pwd;

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

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }
}
