package it.mulders.ol.domain;

import java.util.UUID;

public record Thing(UUID id, String name, String description) {
}
