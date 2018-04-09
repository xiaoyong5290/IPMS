package com.xiaoyong.model.entity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * @author : XiaoYong
 * @date : 2018/3/27 15:29
 * Description    :
 */
@Entity
public class Clazz {
    private int clazzId;
    private String teacher;

    @OneToMany(fetch = FetchType.LAZY,mappedBy = "clazz")
    private List<User> users;

    @Id
    @Column(name = "clazzId")
    public int getClazzId() {
        return clazzId;
    }

    public void setClazzId(int clazzId) {
        this.clazzId = clazzId;
    }

    @Basic
    @Column(name = "teacher")
    public String getTeacher() {
        return teacher;
    }

    public void setTeacher(String teacher) {
        this.teacher = teacher;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Clazz clazz = (Clazz) o;
        return clazzId == clazz.clazzId &&
                Objects.equals(teacher, clazz.teacher);
    }

    @Override
    public int hashCode() {

        return Objects.hash(clazzId, teacher);
    }

 /*   public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }*/
}
