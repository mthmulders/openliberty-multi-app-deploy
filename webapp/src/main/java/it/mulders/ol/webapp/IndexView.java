package it.mulders.ol.webapp;

import it.mulders.ol.domain.DomainBean;
import it.mulders.ol.domain.ThingRepository;
import jakarta.enterprise.context.SessionScoped;
import jakarta.inject.Inject;
import jakarta.inject.Named;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.Serializable;

@Named
@SessionScoped
public class IndexView implements Serializable {
    private static final Logger logger = LoggerFactory.getLogger(IndexView.class);

    private final String javaVersion;
    private final String javaRuntime;

    @Inject
    public IndexView(DomainBean domainBean, ThingRepository thingRepository) {
        logger.info("Preparing view");
        this.javaVersion = domainBean.getJavaVersion();
        this.javaRuntime = domainBean.getJavaRuntime();
        thingRepository.findByName("whatever");
    }

    public String getJavaVersion() {
        return javaVersion;
    }

    public String getJavaRuntime() {
        return javaRuntime;
    }
}
