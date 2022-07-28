package com.example.demo.entity;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "country")
public class Country {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "country_id", nullable = false)
    private Long countryId;
    @NotNull
    private String countryName;

    @OneToMany(mappedBy = "country")
    private List<State> states;
    @CreationTimestamp
    @Column(name = "create_date",nullable = false)
    private Date createDate;
    @UpdateTimestamp
    @Column(name = "update_date",nullable = true)
    private Date updateDate;
    public Country() {
    }

    public Country(Long countryId, String countryName, Date createDate, Date updateDate) {
        this.countryId = countryId;
        this.countryName = countryName;
        this.createDate = createDate;
        this.updateDate = updateDate;
    }

    public Long getCountryId() {
        return countryId;
    }

    public void setCountryId(Long countryId) {
        this.countryId = countryId;
    }

    public String getCountryName() {
        return countryName;
    }

    public void setCountryName(String countryName) {
        this.countryName = countryName;
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
