package com.heavenhr.heavenhr.dao;

import com.heavenhr.heavenhr.entity.OfferEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

@Transactional
public interface OfferDAO extends JpaRepository<OfferEntity, Long> {

}
