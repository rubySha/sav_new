package com.sav.common.util.jwt;

import java.io.Serializable;

/**
 * Created by kaikai on 2018/1/15.
 */
public class JWTInfo implements Serializable,IJWTInfo{

    private String userName;

    private String name;

    private String userId;

    public JWTInfo(String userName, String name, String userId) {
        this.userName = userName;
        this.name = name;
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof JWTInfo)) return false;

        JWTInfo jwtInfo = (JWTInfo) o;

        if (userName != null ? !userName.equals(jwtInfo.userName) : jwtInfo.userName != null) return false;
        return userId != null ? userId.equals(jwtInfo.userId) : jwtInfo.userId == null;
    }

    @Override
    public int hashCode() {
        int result = userName != null ? userName.hashCode() : 0;
        result = 31 * result + (userId != null ? userId.hashCode() : 0);
        return result;
    }
}
