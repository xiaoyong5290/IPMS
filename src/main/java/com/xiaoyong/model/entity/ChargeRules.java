package com.xiaoyong.model.entity;

import javax.persistence.*;

/**
 * @author : XiaoYong
 * @date : 2018/4/10 9:31
 * Description    :
 */
@Entity
@Table(name = "charge_rules", schema = "ipdb", catalog = "")
public class ChargeRules {
    private String customerType;
    private int chargeRule;

    @Id
    @Column(name = "customer_type")
    public String getCustomerType() {
        return customerType;
    }

    public void setCustomerType(String customerType) {
        this.customerType = customerType;
    }

    @Basic
    @Column(name = "charge_rule")
    public int getChargeRule() {
        return chargeRule;
    }

    public void setChargeRule(int chargeRule) {
        this.chargeRule = chargeRule;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        ChargeRules that = (ChargeRules) o;

        if (chargeRule != that.chargeRule) {
            return false;
        }
        if (customerType != null ? !customerType.equals(that.customerType) : that.customerType != null) {
            return false;
        }

        return true;
    }

    @Override
    public int hashCode() {
        int result = customerType != null ? customerType.hashCode() : 0;
        result = 31 * result + chargeRule;
        return result;
    }
}
