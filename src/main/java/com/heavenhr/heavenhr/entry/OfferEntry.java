package com.heavenhr.heavenhr.entry;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;

public class OfferEntry {

    private String jobTitle;

    @JsonFormat(pattern="yyyy-MM-dd")
    private Date startDate;

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
}
