package com.heavenhr.heavenhr.entry;

import com.heavenhr.heavenhr.enumerations.ApplicationStatus;

public class UpdateEntry {
    Long appId;
    ApplicationStatus status;

    public Long getAppId() {
        return appId;
    }

    public void setAppId(Long appId) {
        this.appId = appId;
    }

    public ApplicationStatus getStatus() {
        return status;
    }

    public void setStatus(ApplicationStatus status) {
        this.status = status;
    }
}
