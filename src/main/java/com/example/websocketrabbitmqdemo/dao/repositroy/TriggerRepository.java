package com.example.websocketrabbitmqdemo.dao.repositroy;

import com.example.websocketrabbitmqdemo.dao.entity.TriggerEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface TriggerRepository extends JpaRepository<TriggerEntity, String>,
        JpaSpecificationExecutor<TriggerEntity> {
}
