package com.Employee.repository.primary;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.Employee.entity.primary.PrimaryEntity;

@Repository
public interface PrimaryRepository extends JpaRepository<PrimaryEntity, Long> {
    
}
