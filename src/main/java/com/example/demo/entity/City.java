package com.example.demo.entity;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Date;


@Entity
@Table(name = "city")
public class City {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "city_id", nullable = false)
    private Long cityId;
    @NotNull
    private String cityName;
    @NotNull
    private int zipCode;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name ="state_id")
    State state;

    @CreationTimestamp
    @Column(name = "create_date", updatable = false)
    private Date createDate;
    @UpdateTimestamp
    @Column(name ="update_date",updatable = true)
    private Date updateDate;

    public City(Long cityId, String cityName) {
        this.cityId = cityId;
        this.cityName = cityName;
    }

    public City(String cityName, int zipCode, State state) {
        this.cityName = cityName;
        this.zipCode = zipCode;
        this.state = state;
    }

    public City(Long cityId, String cityName, int zipCode, Date createDate, Date updateDate) {
        this.cityId = cityId;
        this.cityName = cityName;
        this.zipCode = zipCode;
        this.createDate = createDate;
        this.updateDate = updateDate;
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }

    @Override
    public String toString() {
        return "City{" +
                "cityId=" + cityId +
                ", cityName='" + cityName + '\'' +
                ", zipCode=" + zipCode +
                ", state=" + state +
                ", createDate=" + createDate +
                ", updateDate=" + updateDate +
                '}';
    }

    @Override
    public boolean equals(Object obj) {
        return super.equals(obj);
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

    public int getZipCode() {
        return zipCode;
    }

    public void setZipCode(int zipCode) {
        this.zipCode = zipCode;
    }

    public City() {
    }
    public Long getCityId() {
        return cityId;
    }

    public void setCityId(Long cityId) {
        this.cityId = cityId;
    }

    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public Date getUpdateDate() {
        return updateDate;
    }

    public void setUpdateDate(Date updateDate) {
        this.updateDate = updateDate;
    }
}
