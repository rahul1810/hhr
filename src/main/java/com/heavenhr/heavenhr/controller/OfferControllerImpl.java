package com.heavenhr.heavenhr.controller;

import com.heavenhr.heavenhr.entry.OfferEntry;
import com.heavenhr.heavenhr.exception.OfferNotFoundException;
import com.heavenhr.heavenhr.manager.OfferManager;
import com.heavenhr.heavenhr.response.BaseResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;

public class OfferControllerImpl implements OfferController{

    @Autowired
    OfferManager offerManager;

    @Override
    @ResponseStatus(value= HttpStatus.CREATED)
    public BaseResponse createOffer(@RequestBody OfferEntry offerEntry) {
        BaseResponse response = offerManager.createOffer(offerEntry);
        return response;
    }

    @Override
    @ResponseStatus(value = HttpStatus.FOUND)
    public BaseResponse getOfferDetails(@PathVariable("offerId") Long offerId) throws OfferNotFoundException {
        return offerManager.getOfferDetails(offerId);
    }
}
