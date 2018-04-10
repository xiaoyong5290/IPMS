package com.xiaoyong.model.entity;

import javax.persistence.*;

/**
 * @author : XiaoYong
 * @date : 2018/4/10 9:31
 * Description    :
 */
@Entity
@Table(name = "tenant_info", schema = "ipdb", catalog = "")
public class TenantInfo {
    private int tenantId;
    private String tenantName;
    private String tenantTel;
    private int leasehold;
    private String note;

    @Id
    @Column(name = "tenant_id")
    public int getTenantId() {
        return tenantId;
    }

    public void setTenantId(int tenantId) {
        this.tenantId = tenantId;
    }

    @Basic
    @Column(name = "tenant_name")
    public String getTenantName() {
        return tenantName;
    }

    public void setTenantName(String tenantName) {
        this.tenantName = tenantName;
    }

    @Basic
    @Column(name = "tenant_tel")
    public String getTenantTel() {
        return tenantTel;
    }

    public void setTenantTel(String tenantTel) {
        this.tenantTel = tenantTel;
    }

    @Basic
    @Column(name = "leasehold")
    public int getLeasehold() {
        return leasehold;
    }

    public void setLeasehold(int leasehold) {
        this.leasehold = leasehold;
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

        TenantInfo that = (TenantInfo) o;

        if (tenantId != that.tenantId) {
            return false;
        }
        if (leasehold != that.leasehold) {
            return false;
        }
        if (tenantName != null ? !tenantName.equals(that.tenantName) : that.tenantName != null) {
            return false;
        }
        if (tenantTel != null ? !tenantTel.equals(that.tenantTel) : that.tenantTel != null) {
            return false;
        }
        if (note != null ? !note.equals(that.note) : that.note != null) {
            return false;
        }

        return true;
    }

    @Override
    public int hashCode() {
        int result = tenantId;
        result = 31 * result + (tenantName != null ? tenantName.hashCode() : 0);
        result = 31 * result + (tenantTel != null ? tenantTel.hashCode() : 0);
        result = 31 * result + leasehold;
        result = 31 * result + (note != null ? note.hashCode() : 0);
        return result;
    }
}
