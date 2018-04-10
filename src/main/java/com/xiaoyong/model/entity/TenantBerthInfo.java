package com.xiaoyong.model.entity;

import javax.persistence.*;

/**
 * @author : XiaoYong
 * @date : 2018/4/10 9:31
 * Description    :
 */
@Entity
@Table(name = "tenant_berth_info", schema = "ipdb", catalog = "")
public class TenantBerthInfo {
    private int berthId;
    private int tenantId;
    private String position;

    @Id
    @Column(name = "berth_id")
    public int getBerthId() {
        return berthId;
    }

    public void setBerthId(int berthId) {
        this.berthId = berthId;
    }

    @Basic
    @Column(name = "tenant_id")
    public int getTenantId() {
        return tenantId;
    }

    public void setTenantId(int tenantId) {
        this.tenantId = tenantId;
    }

    @Basic
    @Column(name = "position")
    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        TenantBerthInfo that = (TenantBerthInfo) o;

        if (berthId != that.berthId) {
            return false;
        }
        if (tenantId != that.tenantId) {
            return false;
        }
        if (position != null ? !position.equals(that.position) : that.position != null) {
            return false;
        }

        return true;
    }

    @Override
    public int hashCode() {
        int result = berthId;
        result = 31 * result + tenantId;
        result = 31 * result + (position != null ? position.hashCode() : 0);
        return result;
    }
}
