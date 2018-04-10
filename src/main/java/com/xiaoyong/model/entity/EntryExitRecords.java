package com.xiaoyong.model.entity;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Arrays;

/**
 * @author : XiaoYong
 * @date : 2018/4/10 9:31
 * Description    :
 */
@Entity
@Table(name = "entry_exit_records", schema = "ipdb", catalog = "")
public class EntryExitRecords {
    private int recordId;
    private String plateId;
    private Timestamp enterTime;
    private byte[] enterImg;
    private int enterPortId;
    private Timestamp exitTime;
    private byte[] exitImg;
    private Integer exitPortId;
    private String note;

    @Id
    @Column(name = "record_id")
    public int getRecordId() {
        return recordId;
    }

    public void setRecordId(int recordId) {
        this.recordId = recordId;
    }

    @Basic
    @Column(name = "plate_id")
    public String getPlateId() {
        return plateId;
    }

    public void setPlateId(String plateId) {
        this.plateId = plateId;
    }

    @Basic
    @Column(name = "enter_time")
    public Timestamp getEnterTime() {
        return enterTime;
    }

    public void setEnterTime(Timestamp enterTime) {
        this.enterTime = enterTime;
    }

    @Basic
    @Column(name = "enter_img")
    public byte[] getEnterImg() {
        return enterImg;
    }

    public void setEnterImg(byte[] enterImg) {
        this.enterImg = enterImg;
    }

    @Basic
    @Column(name = "enter_port_id")
    public int getEnterPortId() {
        return enterPortId;
    }

    public void setEnterPortId(int enterPortId) {
        this.enterPortId = enterPortId;
    }

    @Basic
    @Column(name = "exit_time")
    public Timestamp getExitTime() {
        return exitTime;
    }

    public void setExitTime(Timestamp exitTime) {
        this.exitTime = exitTime;
    }

    @Basic
    @Column(name = "exit_img")
    public byte[] getExitImg() {
        return exitImg;
    }

    public void setExitImg(byte[] exitImg) {
        this.exitImg = exitImg;
    }

    @Basic
    @Column(name = "exit_port_id")
    public Integer getExitPortId() {
        return exitPortId;
    }

    public void setExitPortId(Integer exitPortId) {
        this.exitPortId = exitPortId;
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

        EntryExitRecords that = (EntryExitRecords) o;

        if (recordId != that.recordId) {
            return false;
        }
        if (enterPortId != that.enterPortId) {
            return false;
        }
        if (plateId != null ? !plateId.equals(that.plateId) : that.plateId != null) {
            return false;
        }
        if (enterTime != null ? !enterTime.equals(that.enterTime) : that.enterTime != null) {
            return false;
        }
        if (!Arrays.equals(enterImg, that.enterImg)) {
            return false;
        }
        if (exitTime != null ? !exitTime.equals(that.exitTime) : that.exitTime != null) {
            return false;
        }
        if (!Arrays.equals(exitImg, that.exitImg)) {
            return false;
        }
        if (exitPortId != null ? !exitPortId.equals(that.exitPortId) : that.exitPortId != null) {
            return false;
        }
        if (note != null ? !note.equals(that.note) : that.note != null) {
            return false;
        }

        return true;
    }

    @Override
    public int hashCode() {
        int result = recordId;
        result = 31 * result + (plateId != null ? plateId.hashCode() : 0);
        result = 31 * result + (enterTime != null ? enterTime.hashCode() : 0);
        result = 31 * result + Arrays.hashCode(enterImg);
        result = 31 * result + enterPortId;
        result = 31 * result + (exitTime != null ? exitTime.hashCode() : 0);
        result = 31 * result + Arrays.hashCode(exitImg);
        result = 31 * result + (exitPortId != null ? exitPortId.hashCode() : 0);
        result = 31 * result + (note != null ? note.hashCode() : 0);
        return result;
    }
}
