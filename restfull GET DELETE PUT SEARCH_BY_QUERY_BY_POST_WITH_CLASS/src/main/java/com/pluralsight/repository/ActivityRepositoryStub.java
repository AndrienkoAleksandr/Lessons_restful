package com.pluralsight.repository;

import com.pluralsight.model.Activity;
import com.pluralsight.model.ActivitySearch;
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

    @Override
    public Activity update(Activity activity) {
        //search the database to see if we have an activity with that id already
        //select * from Activity where id = ?
        //if rs size == 0
        //insert into Activity table
        //else
        //update the Activity
        return activity;
    }

    @Override
    public void delete(String idActivity) {
        //delete from activity where activityid = ?
    }

    @Override
    public List<Activity> findByDescription(List<String> descriptions, int durationFrom, int durationTo) {
       // select * from activities where description in (?,?,?) and duration < durationFrom and duration > durationTo
        List<Activity> activities = new ArrayList<Activity>();

        Activity activity = new Activity();
        activity.setId("2345");
        activity.setDescription("swimming");
        activity.setDuration(55);

        activities.add(activity);

        return activities;
    }

    @Override
    public List<Activity> findByConstraints(ActivitySearch search) {
        System.out.println(search.getDurationTo());
        System.out.println(search.getActivitySearchType());
        List<Activity> activities = new ArrayList<Activity>();
        Activity activity = new Activity();
        activity.setId("2345");
        activity.setDescription("swimming");
        activity.setDuration(55);
        activities.add(activity);
        return activities;
    }
}
