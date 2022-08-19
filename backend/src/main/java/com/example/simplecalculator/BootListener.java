package com.example.simplecalculator;


import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.context.event.ApplicationStartedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;

@Component
@Slf4j
public class BootListener {
    private final EntityManager entityManager;

    public BootListener(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @EventListener
    @Transactional
    public void bootListener(ApplicationStartedEvent event) {
        log.info("Backend initialized");
    }
}
