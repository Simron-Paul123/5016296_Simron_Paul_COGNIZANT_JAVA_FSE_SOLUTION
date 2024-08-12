package com.Employee.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Employee.entity.secondary.SecondaryEntity;
import com.Employee.repository.secondary.SecondaryRepository;

@Service
public class SecondaryService {

    private final SecondaryRepository secondaryRepository;

    @Autowired
    public SecondaryService(SecondaryRepository secondaryRepository) {
        this.secondaryRepository = secondaryRepository;
    }

    public List<SecondaryEntity> findAll() {
        return secondaryRepository.findAll();
    }

    public SecondaryEntity findById(Long id) {
        return secondaryRepository.findById(id).orElse(null);
    }

    public SecondaryEntity save(SecondaryEntity secondaryEntity) {
        return secondaryRepository.save(secondaryEntity);
    }

    public void deleteById(Long id) {
        secondaryRepository.deleteById(id);
    }
}