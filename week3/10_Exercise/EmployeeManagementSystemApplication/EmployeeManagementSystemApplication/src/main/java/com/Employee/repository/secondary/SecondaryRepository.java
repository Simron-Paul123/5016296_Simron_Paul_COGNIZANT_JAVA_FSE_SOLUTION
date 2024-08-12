package com.Employee.repository.secondary;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.Employee.entity.secondary.SecondaryEntity;

@Repository
public interface SecondaryRepository extends JpaRepository<SecondaryEntity, Long> {
   
}