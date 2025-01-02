package it.mulders.ol.domain;

import jakarta.enterprise.context.ApplicationScoped;

import java.util.Properties;

@ApplicationScoped
public class DomainBean {
    private final Properties systemProperties = System.getProperties();

    public String getJavaVersion() {
        return (String) systemProperties.get("java.specification.version");
    }

    public String getJavaRuntime() {
        return (String) systemProperties.get("java.vm.vendor");
    }
}
