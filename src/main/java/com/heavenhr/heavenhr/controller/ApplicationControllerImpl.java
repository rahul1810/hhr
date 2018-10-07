package com.heavenhr.heavenhr.controller;

import com.heavenhr.heavenhr.entry.ApplicationEntry;
import com.heavenhr.heavenhr.entry.OfferEntry;
import com.heavenhr.heavenhr.entry.UpdateEntry;
import com.heavenhr.heavenhr.exception.ApplicationNotFoundException;
import com.heavenhr.heavenhr.exception.OfferNotFoundException;
import com.heavenhr.heavenhr.manager.ApplicationManager;
import com.heavenhr.heavenhr.manager.OfferManager;
import com.heavenhr.heavenhr.response.BaseResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ApplicationControllerImpl extends BaseController implements ApplicationController{

    @Autowired
    OfferManager offerManager;

    @Autowired
    ApplicationManager applicationManager;


    @Override
    @ResponseStatus(value = HttpStatus.ACCEPTED)
    public BaseResponse apply(@RequestBody ApplicationEntry applicationEntry) throws OfferNotFoundException {
        return applicationManager.apply(applicationEntry);
    }



    @Override
    @ResponseStatus(value = HttpStatus.FOUND)
    public BaseResponse getApplicationDetails(@PathVariable("applicationId") Long applicationId) throws ApplicationNotFoundException {
        return applicationManager.getApplicationDetails(applicationId);
    }

    @Override
    @ResponseStatus(value = HttpStatus.FOUND)
    public BaseResponse getTotalApplications() {
        return applicationManager.getCountOfAllApplications();
    }

    @Override
    @ResponseStatus(value = HttpStatus.ACCEPTED)
    public BaseResponse updateApplicationDetails(@RequestBody UpdateEntry updateEntry) throws ApplicationNotFoundException {
        BaseResponse response =  applicationManager.update(updateEntry);
        return response;
    }
}
