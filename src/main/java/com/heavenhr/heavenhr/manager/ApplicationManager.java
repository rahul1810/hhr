package com.heavenhr.heavenhr.manager;


import com.heavenhr.heavenhr.dao.ApplicationDAO;
import com.heavenhr.heavenhr.dao.OfferDAO;
import com.heavenhr.heavenhr.entity.ApplicationEntity;
import com.heavenhr.heavenhr.entity.OfferEntity;
import com.heavenhr.heavenhr.entry.ApplicationEntry;
import com.heavenhr.heavenhr.entry.UpdateEntry;
import com.heavenhr.heavenhr.enumerations.ApplicationStatus;
import com.heavenhr.heavenhr.exception.ApplicationNotFoundException;
import com.heavenhr.heavenhr.exception.DataFormatException;
import com.heavenhr.heavenhr.exception.OfferNotFoundException;
import com.heavenhr.heavenhr.response.BaseResponse;
import com.heavenhr.heavenhr.utils.Vaidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.HashMap;

@Component
public class ApplicationManager {

    @Autowired
    ApplicationDAO applicationDAO;

    @Autowired
    OfferDAO offerDAO;

    @Autowired
    Vaidator vaidator;

    public BaseResponse apply(ApplicationEntry entry) throws OfferNotFoundException, DataFormatException {
        OfferEntity offerEntity = offerDAO.getOne(entry.getOfferId());
        if(offerEntity == null)
            throw new OfferNotFoundException("No offer found");
        if(!vaidator.isValidEmail(entry.getEmail())){
            throw new DataFormatException("Invalid email address");
        }
        ApplicationEntity entity = new ApplicationEntity();
        entity.setOfferId(entry.getOfferId());
        entity.setEmail(entry.getEmail());
        entity.setResume(entry.getResume());
        entity.setApplicationStatus(ApplicationStatus.APPLIED);
        System.out.print(entity);
        applicationDAO.save(entity);
        return new BaseResponse("Success", "200",entity);
    }

    public BaseResponse getApplicationDetails(Long id) throws ApplicationNotFoundException {
        ApplicationEntity entity = null;
        entity = applicationDAO.findById(id)
                .orElseThrow(()->new ApplicationNotFoundException(id.toString()));
        return new BaseResponse("Success", "200",entity);
    }

    public BaseResponse update(UpdateEntry entry) throws ApplicationNotFoundException {
        ApplicationEntity entity = applicationDAO.getOne(entry.getAppId());
        if(entity == null){
            throw new ApplicationNotFoundException(entry.getAppId().toString());
        }
        entity.setApplicationStatus(entry.getStatus());
        applicationDAO.save(entity);
        return new BaseResponse("Success", "200",entry);
    }

    public BaseResponse getCountOfAllApplications(){
        HashMap<String, Long> result = new HashMap<>();
        result.put("count",applicationDAO.count());
        return new BaseResponse("Success", "200",result);
    }


}
