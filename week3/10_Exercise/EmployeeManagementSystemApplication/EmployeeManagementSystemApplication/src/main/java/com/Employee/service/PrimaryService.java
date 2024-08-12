package com.Employee.service;

import com.Employee.entity.primary.PrimaryEntity;
import org.springframework.stereotype.Service;
import javax.persistence.EntityManager;
import javax.transaction.Transactional;
import java.util.List;

@Service
public class PrimaryService {

    private final EntityManager entityManager;

    public PrimaryService(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Transactional
    public void batchInsertPrimaryEntities(List<PrimaryEntity> entities) {
        int batchSize = 50;
        for (int i = 0; i < entities.size(); i++) {
            entityManager.persist(entities.get(i));
            if (i % batchSize == 0 && i > 0) {
                entityManager.flush();
                entityManager.clear();
            }
        }
    }
}
