package com.xiaoyong.model.entity;

import javax.persistence.*;

/**
 * @author : XiaoYong
 * @date : 2018/4/10 9:31
 * Description    :
 */
@Entity
@Table(name = "temporary_car", schema = "ipdb", catalog = "")
public class TemporaryCar {
    private String plateId;
    private String carType;
    private String carColor;

    @Id
    @Column(name = "plate_id")
    public String getPlateId() {
        return plateId;
    }

    public void setPlateId(String plateId) {
        this.plateId = plateId;
    }

    @Basic
    @Column(name = "car_type")
    public String getCarType() {
        return carType;
    }

    public void setCarType(String carType) {
        this.carType = carType;
    }

    @Basic
    @Column(name = "car_color")
    public String getCarColor() {
        return carColor;
    }

    public void setCarColor(String carColor) {
        this.carColor = carColor;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        TemporaryCar that = (TemporaryCar) o;

        if (plateId != null ? !plateId.equals(that.plateId) : that.plateId != null) {
            return false;
        }
        if (carType != null ? !carType.equals(that.carType) : that.carType != null) {
            return false;
        }
        if (carColor != null ? !carColor.equals(that.carColor) : that.carColor != null) {
            return false;
        }

        return true;
    }

    @Override
    public int hashCode() {
        int result = plateId != null ? plateId.hashCode() : 0;
        result = 31 * result + (carType != null ? carType.hashCode() : 0);
        result = 31 * result + (carColor != null ? carColor.hashCode() : 0);
        return result;
    }
}
