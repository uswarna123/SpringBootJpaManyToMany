package com.example.demo.entity;
import com.fasterxml.jackson.annotation.JsonBackReference;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.Date;
import java.util.List;
import java.util.Objects;

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
    @JsonBackReference
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

    public List<State> getStates() {
        return states;
    }

    public void setStates(List<State> states) {
        this.states = states;
    }



    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Country country = (Country) o;
        return Objects.equals(countryId, country.countryId) && Objects.equals(countryName, country.countryName) && Objects.equals(states, country.states) && Objects.equals(createDate, country.createDate) && Objects.equals(updateDate, country.updateDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(countryId, countryName, states, createDate, updateDate);
    }
}
