package com.heavenhr.heavenhr.entity;

import javax.persistence.*;
import java.util.Date;
import java.util.List;


@Entity
public class OfferEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "offer_id")
    private long offerId;

    @Column(name = "job_title", unique = true, nullable = false)
    private String jobTitle;

    @Column(name = "start_date")
    private Date startDate;

    @OneToMany(mappedBy = "linkedOffer", cascade = CascadeType.ALL)
    List<ApplicationEntity> applicationForOffer;


    public long getOfferId() {
        return offerId;
    }

    public void setOfferId(long offerId) {
        this.offerId = offerId;
    }

    public String getJobTitle() {
        return jobTitle;
    }

    public void setJobTitle(String jobTitle) {
        this.jobTitle = jobTitle;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

/*
    public List<ApplicationEntity> getApplicationForOffer() {
        return applicationForOffer;
    }
*/

    /*public void setApplicationForOffer(List<ApplicationEntity> applicationForOffer) {
        this.applicationForOffer = applicationForOffer;
    }*/

    @Override
    public String toString() {
        return "OfferEntity{" +
                "offerId=" + offerId +
                ", jobTitle='" + jobTitle + '\'' +
                ", startDate=" + startDate +
                '}';
    }
}
