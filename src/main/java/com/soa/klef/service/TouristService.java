package com.soa.klef.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.soa.klef.entity.Tourist;
import com.soa.klef.repository.TouristRepository;

@Service
public class TouristService {

    private final TouristRepository repository;

    public TouristService(TouristRepository repository) {
        this.repository = repository;
    }

    public List<Tourist> getAllTourists() {
        return repository.findAll();
    }

    public Optional<Tourist> getTouristById(Long id) {
        return repository.findById(id);
    }
}
