package it.mulders.ol.jpa;

import it.mulders.ol.domain.Thing;
import it.mulders.ol.domain.ThingRepository;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.persistence.EntityManager;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Optional;

@ApplicationScoped
public class JpaThingRepository implements ThingRepository {
    private static final Logger log = LoggerFactory.getLogger(JpaThingRepository.class);
    private final EntityManager em;

    @Inject
    public JpaThingRepository(final EntityManager em) {
        this.em = em;
    }

    @Override
    public Optional<Thing> findByName(String name) {
        log.info("Looking up thing with name {}", name);
        log.info("ThingEntity lives in classloader {}", ThingEntity.class.getClassLoader());
        var query = this.em.createQuery("select t from ThingEntity t where t.name = :name", ThingEntity.class);
        var result = query.setParameter("name", name)
                .getResultStream()
                .map(entity -> new Thing(entity.getId(), entity.getName(), entity.getDescription()))
                .findAny();
        return result;
    }
}
