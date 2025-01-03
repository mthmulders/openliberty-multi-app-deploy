package it.mulders.ol.jpa;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.enterprise.inject.Produces;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.PersistenceUnit;

@ApplicationScoped
public class EntityManagerProducer {
    @PersistenceUnit
    private EntityManagerFactory emf;

    @Produces
    public EntityManager createEntityManager() {
        return emf.createEntityManager();
    }
}
