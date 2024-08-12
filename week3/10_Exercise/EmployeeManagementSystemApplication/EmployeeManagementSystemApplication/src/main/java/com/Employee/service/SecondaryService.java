package com.Employee.service;

import com.Employee.entity.secondary.SecondaryEntity;
import org.springframework.stereotype.Service;
import javax.persistence.EntityManager;
import javax.transaction.Transactional;
import java.util.List;

@Service
public class SecondaryService {

    private final EntityManager entityManager;

    public SecondaryService(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Transactional
    public void batchInsertSecondaryEntities(List<SecondaryEntity> entities) {
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
