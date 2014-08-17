package com.pluralsight.model;

import java.util.List;

/**
 * Created by USER on 10.05.2014.
 */
public class ActivitySearch {

    private int durationFrom;
    private int DurationTo;
    private List<String> duration;
    private ActivitySearchType activitySearchType;

    public ActivitySearchType getActivitySearchType() {
        return activitySearchType;
    }

    public void setActivitySearchType(ActivitySearchType activitySearchType) {
        this.activitySearchType = activitySearchType;
    }

    public int getDurationFrom() {
        return durationFrom;
    }

    public void setDurationFrom(int durationFrom) {
        this.durationFrom = durationFrom;
    }

    public List<String> getDuration() {
        return duration;
    }

    public void setDuration(List<String> duration) {
        this.duration = duration;
    }

    public int getDurationTo() {
        return DurationTo;
    }

    public void setDurationTo(int durationTo) {
        DurationTo = durationTo;
    }
}
