package com.xiaoyong.model.entity;

import javax.persistence.*;

/**
 * @author : XiaoYong
 * @date : 2018/4/10 9:31
 * Description    :
 */
@Entity
@Table(name = "business_info", schema = "ipdb", catalog = "")
public class BusinessInfo {
    private int businessId;
    private String businessName;
    private String businessTel;
    private String note;

    @Id
    @Column(name = "business_id")
    public int getBusinessId() {
        return businessId;
    }

    public void setBusinessId(int businessId) {
        this.businessId = businessId;
    }

    @Basic
    @Column(name = "business_name")
    public String getBusinessName() {
        return businessName;
    }

    public void setBusinessName(String businessName) {
        this.businessName = businessName;
    }

    @Basic
    @Column(name = "business_tel")
    public String getBusinessTel() {
        return businessTel;
    }

    public void setBusinessTel(String businessTel) {
        this.businessTel = businessTel;
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

        BusinessInfo that = (BusinessInfo) o;

        if (businessId != that.businessId) {
            return false;
        }
        if (businessName != null ? !businessName.equals(that.businessName) : that.businessName != null) {
            return false;
        }
        if (businessTel != null ? !businessTel.equals(that.businessTel) : that.businessTel != null) {
            return false;
        }
        if (note != null ? !note.equals(that.note) : that.note != null) {
            return false;
        }

        return true;
    }

    @Override
    public int hashCode() {
        int result = businessId;
        result = 31 * result + (businessName != null ? businessName.hashCode() : 0);
        result = 31 * result + (businessTel != null ? businessTel.hashCode() : 0);
        result = 31 * result + (note != null ? note.hashCode() : 0);
        return result;
    }
}
