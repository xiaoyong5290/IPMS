package com.xiaoyong.model.entity;

import javax.persistence.*;
import java.util.Objects;

/**
 * @author : XiaoYong
 * @date : 2018/3/27 15:31
 * Description    :
 */
@Entity
public class User {
    private int userid;
    private String username;
    private String pwd;

    @JoinColumn(name="clazzId",unique = true)
    @ManyToOne(fetch = FetchType.EAGER,cascade = CascadeType.REMOVE,targetEntity = Clazz.class)
    private Integer clazz;

    @Id
    @Column(name = "userid")
    public int getUserid() {
        return userid;
    }

    public void setUserid(int userid) {
        this.userid = userid;
    }

    @Basic
    @Column(name = "username")
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @Basic
    @Column(name = "pwd")
    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    @Basic
    @Column(name = "clazz")
    public Integer getClazz() {
        return clazz;
    }

    public void setClazz(Integer clazz) {
        this.clazz = clazz;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        User user = (User) o;
        return userid == user.userid &&
                Objects.equals(username, user.username) &&
                Objects.equals(pwd, user.pwd) &&
                Objects.equals(clazz, user.clazz);
    }

    @Override
    public int hashCode() {

        return Objects.hash(userid, username, pwd, clazz);
    }

    @Override
    public String toString() {
        return "userId  :   " + userid + "  username   :   " + username +
                "   password   ：  " + pwd + "   class   :   " + clazz;
    }
}
