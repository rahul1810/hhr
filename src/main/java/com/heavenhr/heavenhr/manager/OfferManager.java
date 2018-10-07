package com.heavenhr.heavenhr.manager;

import com.heavenhr.heavenhr.dao.OfferDAO;
import com.heavenhr.heavenhr.entity.OfferEntity;
import com.heavenhr.heavenhr.entry.OfferEntry;
import com.heavenhr.heavenhr.exception.OfferNotFoundException;
import com.heavenhr.heavenhr.response.BaseResponse;
import org.hibernate.exception.ConstraintViolationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Component;

import javax.persistence.EntityNotFoundException;
import java.util.List;


@Component
public class OfferManager {

    @Autowired
    OfferDAO offerDAO;
    public BaseResponse createOffer(OfferEntry offerEntry){
        OfferEntity offerEntity = new OfferEntity();
        offerEntity.setJobTitle(offerEntry.getJobTitle());
        offerEntity.setStartDate(offerEntry.getStartDate());
        offerDAO.save(offerEntity);
        return new BaseResponse("Success", "200", offerEntity);
    }

    public BaseResponse getOfferDetails(Long offerId) throws OfferNotFoundException {
        OfferEntity entity = null;
        entity = offerDAO.findById(offerId).orElseThrow(() -> new OfferNotFoundException(offerId.toString()));
        return new BaseResponse("Success", "200", entity);

    }
}
