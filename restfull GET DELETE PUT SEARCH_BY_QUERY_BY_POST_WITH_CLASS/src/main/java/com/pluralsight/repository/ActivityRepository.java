package com.pluralsight.repository;

import com.pluralsight.model.Activity;
import com.pluralsight.model.ActivitySearch;

import java.util.List;

/**
 * Created by USER on 07.05.2014.
 */
public interface ActivityRepository {
    public List<Activity> findAllActivity();

    public Activity findActivity(String activityId);

    void create(Activity activity);

    public Activity update(Activity activity);

    void delete(String idActivity);

    List<Activity> findByDescription(List<String> paramValues, int durationFrom, int durationTo);

    List<Activity> findByConstraints(ActivitySearch activitySearch);
}
