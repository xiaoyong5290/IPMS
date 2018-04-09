package com.xiaoyong.model.entity;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Arrays;
import java.util.Objects;

/**
 * @author : XiaoYong
 * @date : 2018/3/30 13:43
 * Description    :
 */
@Entity
@SuppressWarnings("unused")
public class Image {
    private int imageId;
    private String imageName;
    private byte[] data;

    @Id
    @Column(name = "imageId")
    public int getImageId() {
        return imageId;
    }

    public void setImageId(int imageId) {
        this.imageId = imageId;
    }

    @Basic
    @Column(name = "imageName")
    public String getImageName() {
        return imageName;
    }

    public void setImageName(String imageName) {
        this.imageName = imageName;
    }

    @Basic
    @Column(name = "data")
    public byte[] getData() {
        return data;
    }

    public void setData(byte[] data) {
        this.data = data;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Image image = (Image) o;
        return imageId == image.imageId &&
                Objects.equals(imageName, image.imageName) &&
                Arrays.equals(data, image.data);
    }

    @Override
    public int hashCode() {

        int result = Objects.hash(imageId, imageName);
        result = 31 * result + Arrays.hashCode(data);
        return result;
    }
}
