package it.mulders.ol.api;

import it.mulders.ol.domain.DomainBean;
import it.mulders.ol.domain.ThingRepository;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@ApplicationScoped
@Path("/status")
public class StatusResource {
    private static final Logger logger = LoggerFactory.getLogger(StatusResource.class);

    @Inject
    private DomainBean domainBean;

    @Inject
    private RandomNumberGenerator randomNumberGenerator;

    @Inject
    private ThingRepository thingRepository;

    public StatusResource() {
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getStatus() {
        thingRepository.findByName("whatever");
        logger.info("Preparing response");
        var entity = new StatusDTO(
                this.domainBean.getJavaVersion(),
                this.domainBean.getJavaRuntime(),
                this.randomNumberGenerator.randomLong()
        );

        return Response.ok(entity).build();
    }
}
