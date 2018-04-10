package com.xiaoyong.model.entity;

import javax.persistence.*;

/**
 * @author : XiaoYong
 * @date : 2018/4/10 9:31
 * Description    :
 */
@Entity
@Table(name = "user_info", schema = "ipdb", catalog = "")
public class UserInfo {
    private String user;
    private String password;
    private int level;

    @Id
    @Column(name = "user")
    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    @Basic
    @Column(name = "password")
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Basic
    @Column(name = "level")
    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        UserInfo userInfo = (UserInfo) o;

        if (level != userInfo.level) {
            return false;
        }
        if (user != null ? !user.equals(userInfo.user) : userInfo.user != null) {
            return false;
        }
        if (password != null ? !password.equals(userInfo.password) : userInfo.password != null) {
            return false;
        }

        return true;
    }

    @Override
    public int hashCode() {
        int result = user != null ? user.hashCode() : 0;
        result = 31 * result + (password != null ? password.hashCode() : 0);
        result = 31 * result + level;
        return result;
    }
}
