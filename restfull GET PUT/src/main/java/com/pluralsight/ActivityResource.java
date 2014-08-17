package com.pluralsight;

import java.util.List;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.MultivaluedMap;
import javax.ws.rs.core.Response;

import com.pluralsight.model.Activity;
import com.pluralsight.model.User;
import com.pluralsight.repository.ActivityRepository;
import com.pluralsight.repository.ActivityRepositoryStub;

/**
 * Created by USER on 07.05.2014.
 */
@Path("activities")  //http:localhost:8080/exercise-services/webapi/activities
public class ActivityResource {
    private ActivityRepository activityRepository = new ActivityRepositoryStub();

    @Path("activity")
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    public Activity createActivity(Activity activity) {
        System.out.println(activity.getDescription());
        System.out.println(activity.getDuration());
        activityRepository.create(activity);
        return activity;
    }

    @Path("activity")
    @POST
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    public Activity createActivityParams(MultivaluedMap<String, String> formParams) {
        System.out.println(formParams.getFirst("description"));
        System.out.println(formParams.getFirst("duration"));
        Activity activity = new Activity();
        activity.setDescription(formParams.getFirst("description"));
        activity.setDuration(Integer.parseInt(formParams.getFirst("duration")));
        activityRepository.create(activity);
        return activity;
    }

    @GET
    @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    public List<Activity> getAllActivities() {
        return activityRepository.findAllActivity();
    }

    @Path("/{activityId}")  //http:localhost:8080/exercise-services/webapi/activities/1234
    @GET
    @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    public Response getActivity(@PathParam("activityId") String activityId) {
        if (activityId == null || activityId.length() < 4) {
            return Response.status(Response.Status.BAD_REQUEST).build();
        }
        Activity activity = activityRepository.findActivity(activityId);
        if (activity == null) {
            return Response.status(Response.Status.NOT_FOUND).build();
        }
        return Response.ok().entity(activity).build();
    }

    @Path("/{id}/user")  //http:localhost:8080/exercise-services/webapi/activities/1234
    @GET
    @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    public User getActivityUser(@PathParam("id") String activityId) {
        Activity activity = activityRepository.findActivity(activityId);
        User user = activity.getUser();
        return user;
        //return activityRepository.findActivity(activityId).getUser();
    }
}
