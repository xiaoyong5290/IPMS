package com.xiaoyong.model.entity;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotBlank;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Null;

/**
 * @author : XiaoYong
 * @date : 2018/4/10 9:31
 * Description    :
 */
@Entity
@SuppressWarnings("unused")
public class Blacklist {
    @Length(min = 8,max = 8,message = "plateId.LengthError")
    @NotNull(message = "plateId.Null")
    private String plateId;
    @Length(max = 100,message = "blackListNote.TooLong")
    @Null
    private String note;

    @Id
    @Column(name = "plate_id")
    public String getPlateId() {
        return plateId;
    }

    public void setPlateId(String plateId) {
        this.plateId = plateId;
    }

    @Basic
    @Column(name = "note")
    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        Blacklist blacklist = (Blacklist) o;

        if (plateId != null ? !plateId.equals(blacklist.plateId) : blacklist.plateId != null) {
            return false;
        }
        if (note != null ? !note.equals(blacklist.note) : blacklist.note != null) {
            return false;
        }

        return true;
    }

    @Override
    public int hashCode() {
        int result = plateId != null ? plateId.hashCode() : 0;
        result = 31 * result + (note != null ? note.hashCode() : 0);
        return result;
    }
}
