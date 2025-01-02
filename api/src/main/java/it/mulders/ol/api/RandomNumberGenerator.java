package it.mulders.ol.api;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Named;

import java.security.SecureRandom;
import java.util.Random;

@ApplicationScoped
@Named
public class RandomNumberGenerator {
    private static final Random RANDOM = new SecureRandom();

    public long randomLong() {
        return RANDOM.nextLong();
    }
}
