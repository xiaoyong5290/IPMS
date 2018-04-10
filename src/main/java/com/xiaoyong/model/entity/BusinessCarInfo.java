package com.xiaoyong.model.entity;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotBlank;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

/**
 * @author : XiaoYong
 * @date : 2018/4/10 9:31
 * Description    :
 */
@Entity
@Table(name = "business_car_info", schema = "ipdb", catalog = "")
public class BusinessCarInfo {
    @Length(min = 8,max = 8,message = "plateId.LengthError")
    @NotNull(message = "plateId.Null")
    private String plateId;
    @Length(min = 10,max = 10,message = "businessId.LengthError")
    @NotNull(message = "businessId.Null")
    private int businessId;
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
    @Column(name = "business_id")
    public int getBusinessId() {
        return businessId;
    }

    public void setBusinessId(int businessId) {
        this.businessId = businessId;
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

        BusinessCarInfo that = (BusinessCarInfo) o;

        if (businessId != that.businessId) {
            return false;
        }
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
        result = 31 * result + businessId;
        result = 31 * result + (carType != null ? carType.hashCode() : 0);
        result = 31 * result + (carColor != null ? carColor.hashCode() : 0);
        return result;
    }
}
