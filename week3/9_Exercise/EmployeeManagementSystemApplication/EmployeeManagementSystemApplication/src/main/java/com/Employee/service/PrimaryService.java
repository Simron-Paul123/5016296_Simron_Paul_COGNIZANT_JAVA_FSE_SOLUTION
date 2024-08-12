package com.Employee.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Employee.entity.primary.PrimaryEntity;
import com.Employee.repository.primary.PrimaryRepository;

@Service
public class PrimaryService {

    private final PrimaryRepository primaryRepository;

    @Autowired
    public PrimaryService(PrimaryRepository primaryRepository) {
        this.primaryRepository = primaryRepository;
    }

    public List<PrimaryEntity> findAll() {
        return primaryRepository.findAll();
    }

    public PrimaryEntity findById(Long id) {
        return primaryRepository.findById(id).orElse(null);
    }

    public PrimaryEntity save(PrimaryEntity primaryEntity) {
        return primaryRepository.save(primaryEntity);
    }

    public void deleteById(Long id) {
        primaryRepository.deleteById(id);
    }
}