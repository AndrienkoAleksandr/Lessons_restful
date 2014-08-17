package com.pluralsight.client;

import com.pluralsight.model.Activity;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;
/**
 * Created by USER on 07.05.2014.
 */
public class ActivityClientTest {
    @Test
    public void testGet() {
        ActivityClient activityClient = new ActivityClient();
        activityClient.get("1234");
        System.out.println(activityClient);
        assertNotNull(activityClient);
    }

    @Test
    public void testGetList() {
        ActivityClient activityClient = new ActivityClient();
        List<Activity> activityList = activityClient.get();
        assertNotNull(activityList);
    }

    @Test
    public void testCreate() {
        ActivityClient activityClient = new ActivityClient();
        Activity activity = new Activity();
        activity.setDuration(90);
        activity.setDescription("Swimming");
        activity = activityClient.create(activity);
        assertNotNull(activity);
    }

    @Test(expected = RuntimeException.class)
    public void testGetWithBadRequest() {
        ActivityClient activityClient = new ActivityClient();
        activityClient.get("123");

    }

    @Test(expected = RuntimeException.class)
    public void testGetWithNotFound() {
        ActivityClient activityClient = new ActivityClient();
        activityClient.get("7777");
    }
}
