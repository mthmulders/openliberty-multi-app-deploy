package it.mulders.ol.domain;

import java.util.Optional;

public interface ThingRepository {
    Optional<Thing> findByName(String name);
}
