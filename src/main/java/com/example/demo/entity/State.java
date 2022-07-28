package com.example.demo.entity;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "state")
public class State {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "state_id", nullable = false)
    private Long stateId;
    @NotNull
    private String stateName;

    @OneToMany(mappedBy = "state")
    private List<City> cities;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "country_id")
    private Country country;
    @CreationTimestamp
    @Column(name = "create_date",updatable = false )
    private Date createDate;
    @UpdateTimestamp
    @Column(name = "update_date",updatable = true)
    private Date updateDate;



    public State() {
    }
    public State(Long stateId, String stateName, Date createDate, Date updateDate) {
        this.stateId = stateId;
        this.stateName = stateName;
        this.createDate = createDate;
        this.updateDate = updateDate;
    }
    public Long getStateId() {
        return stateId;
    }

    public void setStateId(Long stateId) {
        this.stateId = stateId;
    }

    public String getStateName() {
        return stateName;
    }

    public void setStateName(String stateName) {
        this.stateName = stateName;
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
