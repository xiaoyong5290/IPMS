package com.xiaoyong.model.entity;

import javax.persistence.*;
import java.sql.Timestamp;

/**
 * @author : XiaoYong
 * @date : 2018/4/10 9:31
 * Description    :
 */
@Entity
@Table(name = "tenant_order", schema = "ipdb", catalog = "")
@SuppressWarnings("unused")
public class TenantOrder {
    private int orderId;
    private int tenantId;
    private Timestamp startTime;
    private Timestamp endTime;
    private int money;
    private int paymentState;

    @Id
    @Column(name = "order_id")
    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
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
    @Column(name = "start_time")
    public Timestamp getStartTime() {
        return startTime;
    }

    public void setStartTime(Timestamp startTime) {
        this.startTime = startTime;
    }

    @Basic
    @Column(name = "end_time")
    public Timestamp getEndTime() {
        return endTime;
    }

    public void setEndTime(Timestamp endTime) {
        this.endTime = endTime;
    }

    @Basic
    @Column(name = "money")
    public int getMoney() {
        return money;
    }

    public void setMoney(int money) {
        this.money = money;
    }

    @Basic
    @Column(name = "payment_state")
    public int getPaymentState() {
        return paymentState;
    }

    public void setPaymentState(int paymentState) {
        this.paymentState = paymentState;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        TenantOrder that = (TenantOrder) o;

        if (orderId != that.orderId) {
            return false;
        }
        if (tenantId != that.tenantId) {
            return false;
        }
        if (money != that.money) {
            return false;
        }
        if (paymentState != that.paymentState) {
            return false;
        }
        if (startTime != null ? !startTime.equals(that.startTime) : that.startTime != null) {
            return false;
        }
        if (endTime != null ? !endTime.equals(that.endTime) : that.endTime != null) {
            return false;
        }

        return true;
    }

    @Override
    public int hashCode() {
        int result = orderId;
        result = 31 * result + tenantId;
        result = 31 * result + (startTime != null ? startTime.hashCode() : 0);
        result = 31 * result + (endTime != null ? endTime.hashCode() : 0);
        result = 31 * result + money;
        result = 31 * result + paymentState;
        return result;
    }
}
