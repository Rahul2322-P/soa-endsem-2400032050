package com.soa.klef.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.soa.klef.entity.Tourist;

public interface TouristRepository extends JpaRepository<Tourist, Long> {
}
