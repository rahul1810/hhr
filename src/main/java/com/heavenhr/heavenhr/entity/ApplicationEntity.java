package com.heavenhr.heavenhr.entity;

import com.heavenhr.heavenhr.enumerations.ApplicationStatus;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
public class ApplicationEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long appId;

    @Column(name = "offer_id", updatable = false)
    @NotNull
    Long offerId;


    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name= "offer_id", referencedColumnName = "offer_id", insertable = false, updatable = false)
    OfferEntity linkedOffer;

    @Column(updatable = false)
    @NotNull
    String email;

    @Column(updatable = false)
    @NotNull
    String resume;

    @Column(updatable = true)
    @NotNull
    ApplicationStatus applicationStatus;

    public long getAppId() {
        return appId;
    }

    public void setAppId(long appId) {
        this.appId = appId;
    }

    public Long getOfferId() {
        return offerId;
    }

    public void setOfferId(Long offerId) {
        this.offerId = offerId;
    }

    /*public OfferEntity getLinkedOffer() {
        return linkedOffer;
    }

    public void setLinkedOffer(OfferEntity linkedOffer) {
        this.linkedOffer = linkedOffer;
    }*/

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getResume() {
        return resume;
    }

    public void setResume(String resume) {
        this.resume = resume;
    }

    public ApplicationStatus getApplicationStatus() {
        return applicationStatus;
    }

    public void setApplicationStatus(ApplicationStatus applicationStatus) {
        this.applicationStatus = applicationStatus;
    }

    @Override
    public String toString() {
        return "ApplicationEntity{" +
                "appId=" + appId +
                ", offerId=" + offerId +
                ", email='" + email + '\'' +
                ", resume='" + resume + '\'' +
                ", applicationStatus=" + applicationStatus +
                '}';
    }

    @PostUpdate
    void sendNotification(){
        switch (applicationStatus){
            case HIRED:
                System.out.println("Congratulations, you have been hired");
                break;

            case INVITED:
                System.out.println("Based on your application, we invite you take this test");
                break;

            case APPLIED:
                System.out.println("We have received you application");
                break;
            case REJECTED:
                System.out.println("Unfortunately we would not be moving ahead with your application");
        }
    }
}
