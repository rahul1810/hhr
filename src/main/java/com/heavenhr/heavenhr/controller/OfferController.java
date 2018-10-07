package com.heavenhr.heavenhr.controller;

import com.heavenhr.heavenhr.entry.OfferEntry;
import com.heavenhr.heavenhr.exception.OfferNotFoundException;
import com.heavenhr.heavenhr.response.BaseResponse;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/offer")
public interface OfferController {
    @PostMapping(
            value = "/create",
            consumes = MediaType.APPLICATION_JSON_VALUE
    )
    public BaseResponse createOffer(@RequestBody OfferEntry offerEntry);

    @GetMapping("/details/{offerId}")
    public BaseResponse getOfferDetails(@PathVariable("offerId") Long offerId) throws OfferNotFoundException;

}
