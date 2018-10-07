package com.heavenhr.heavenhr.dao;

import com.heavenhr.heavenhr.entity.ApplicationEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ApplicationDAO extends JpaRepository<ApplicationEntity, Long> {
}
