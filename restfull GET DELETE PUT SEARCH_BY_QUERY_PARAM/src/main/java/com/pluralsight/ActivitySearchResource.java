package com.pluralsight;

import com.pluralsight.model.Activity;
import com.pluralsight.repository.ActivityRepository;
import com.pluralsight.repository.ActivityRepositoryStub;

import javax.ws.rs.*;
import javax.ws.rs.core.GenericEntity;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

/**
 * Created by USER on 10.05.2014.
 */
@Path("search")
public class ActivitySearchResource {

    private ActivityRepository activityRepository = new ActivityRepositoryStub();

    @Path("activities")
    @GET
    @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    public Response search(@QueryParam("description") List<String> paramValues,
                           @QueryParam("durationFrom") int durationFrom,
                           @QueryParam("durationTo") int durationTo) {
        final List<Activity> activities =  activityRepository.findByDescription(paramValues, durationFrom, durationTo);
        System.out.println(paramValues + " " + durationFrom + " " + durationTo);
        if (activities == null || activities.size() < 0) {
            Response.status(Response.Status.NOT_FOUND);
        }
        return Response.ok().entity(new GenericEntity<List<Activity>>(activities) {}).build();
    }

}
