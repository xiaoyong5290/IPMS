package com.xiaoyong.model.entity;

import javax.persistence.*;
import java.sql.Timestamp;

/**
 * @author : XiaoYong
 * @date : 2018/4/10 9:31
 * Description    :
 */
@Entity
@Table(name = "order", schema = "ipdb", catalog = "")
public class Order {
    private int orderId;
    private int recordId;
    private Timestamp payTime;
    private int parkingCost;
    private int orderState;
    private String note;

    @Id
    @Column(name = "order_id")
    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    @Basic
    @Column(name = "record_id")
    public int getRecordId() {
        return recordId;
    }

    public void setRecordId(int recordId) {
        this.recordId = recordId;
    }

    @Basic
    @Column(name = "pay_time")
    public Timestamp getPayTime() {
        return payTime;
    }

    public void setPayTime(Timestamp payTime) {
        this.payTime = payTime;
    }

    @Basic
    @Column(name = "parking_cost")
    public int getParkingCost() {
        return parkingCost;
    }

    public void setParkingCost(int parkingCost) {
        this.parkingCost = parkingCost;
    }

    @Basic
    @Column(name = "order_state")
    public int getOrderState() {
        return orderState;
    }

    public void setOrderState(int orderState) {
        this.orderState = orderState;
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

        Order order = (Order) o;

        if (orderId != order.orderId) {
            return false;
        }
        if (recordId != order.recordId) {
            return false;
        }
        if (parkingCost != order.parkingCost) {
            return false;
        }
        if (orderState != order.orderState) {
            return false;
        }
        if (payTime != null ? !payTime.equals(order.payTime) : order.payTime != null) {
            return false;
        }
        if (note != null ? !note.equals(order.note) : order.note != null) {
            return false;
        }

        return true;
    }

    @Override
    public int hashCode() {
        int result = orderId;
        result = 31 * result + recordId;
        result = 31 * result + (payTime != null ? payTime.hashCode() : 0);
        result = 31 * result + parkingCost;
        result = 31 * result + orderState;
        result = 31 * result + (note != null ? note.hashCode() : 0);
        return result;
    }
}
