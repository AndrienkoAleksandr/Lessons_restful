package com.pluralsight.repository;

import com.pluralsight.model.Activity;
import com.pluralsight.model.User;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by USER on 07.05.2014.
 */
public class ActivityRepositoryStub implements ActivityRepository {
    @Override
    public List<Activity> findAllActivity() {
        List<Activity> activities = new ArrayList<Activity>();
        Activity activity1 = new Activity();
        activity1.setDescription("Swimming");
        activity1.setDuration(55);
        Activity activity2 = new Activity();
        activity2.setDescription("Cycling");
        activity2.setDuration(120);
        activities.add(activity1);
        activities.add(activity2);
        return activities;
    }

    @Override
    public Activity findActivity(String activityId) {
        Activity activity1 = new Activity();
        if(activityId.equals("7777")) {
            return null;
        }
        activity1.setId("1234");
        activity1.setDescription("Swimming");
        activity1.setDuration(55);
        User user = new User();
        user.setId("5678");
        user.setName("Bryan");
        activity1.setUser(user);
        return activity1;
    }

    @Override
    public void create(Activity activity) {
        //should issue a insert statement to the db
    }
}
