package com.heavenhr.heavenhr.controller;

import com.heavenhr.heavenhr.entry.ApplicationEntry;
import com.heavenhr.heavenhr.entry.OfferEntry;
import com.heavenhr.heavenhr.entry.UpdateEntry;
import com.heavenhr.heavenhr.exception.ApplicationNotFoundException;
import com.heavenhr.heavenhr.exception.OfferNotFoundException;
import com.heavenhr.heavenhr.response.BaseResponse;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/application")
public interface ApplicationController {

    @PostMapping(
            value = "/apply",
            consumes = MediaType.APPLICATION_JSON_VALUE
    )
    public BaseResponse apply(@RequestBody ApplicationEntry applicationEntry) throws OfferNotFoundException;


    @GetMapping("/details/{applicationId}")
    public BaseResponse getApplicationDetails(@PathVariable("applicationId") Long applicationId) throws ApplicationNotFoundException;

    @RequestMapping(
            value = "/gettotalapplications",
            method = RequestMethod.GET,
            consumes = MediaType.APPLICATION_JSON_VALUE
    )
    public BaseResponse getTotalApplications();


    @RequestMapping(
            value = "/update",
            method = RequestMethod.PUT,
            consumes = MediaType.APPLICATION_JSON_VALUE
    )
    public BaseResponse updateApplicationDetails(@RequestBody UpdateEntry entry) throws ApplicationNotFoundException;
}
