package com.xiaoyong.model.entity;

import javax.persistence.*;

/**
 * @author : XiaoYong
 * @date : 2018/4/10 9:31
 * Description    :
 */
@Entity
@Table(name = "port_info", schema = "ipdb", catalog = "")
public class PortInfo {
    private int portId;
    private String portName;
    private int portType;
    private int usability;

    @Id
    @Column(name = "port_id")
    public int getPortId() {
        return portId;
    }

    public void setPortId(int portId) {
        this.portId = portId;
    }

    @Basic
    @Column(name = "port_name")
    public String getPortName() {
        return portName;
    }

    public void setPortName(String portName) {
        this.portName = portName;
    }

    @Basic
    @Column(name = "port_type")
    public int getPortType() {
        return portType;
    }

    public void setPortType(int portType) {
        this.portType = portType;
    }

    @Basic
    @Column(name = "usability")
    public int getUsability() {
        return usability;
    }

    public void setUsability(int usability) {
        this.usability = usability;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        PortInfo portInfo = (PortInfo) o;

        if (portId != portInfo.portId) {
            return false;
        }
        if (portType != portInfo.portType) {
            return false;
        }
        if (usability != portInfo.usability) {
            return false;
        }
        if (portName != null ? !portName.equals(portInfo.portName) : portInfo.portName != null) {
            return false;
        }

        return true;
    }

    @Override
    public int hashCode() {
        int result = portId;
        result = 31 * result + (portName != null ? portName.hashCode() : 0);
        result = 31 * result + portType;
        result = 31 * result + usability;
        return result;
    }
}
