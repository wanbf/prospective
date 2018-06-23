package com.angel.prospective.util.date;

/**
 * Created by wanbf on 2017/11/22.
 */
public enum DateUnit {
    MS(1),
    SECOND(1000),
    MINUTE(SECOND.getMillis() * 60),
    HOUR(MINUTE.getMillis() * 60),
    DAY(HOUR.getMillis() * 24),
    WEEK(DAY.getMillis() * 7);

    private long millis;

    private DateUnit(long millis) {
        this.millis = millis;
    }

    public long getMillis() {
        return millis;
    }
}
