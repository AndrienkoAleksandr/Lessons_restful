package com.pluralsight.repository;

import com.pluralsight.model.Activity;

import java.util.List;

/**
 * Created by USER on 07.05.2014.
 */
public interface ActivityRepository {
    public List<Activity> findAllActivity();
    public Activity findActivity(String activityId);
}
