package com.angel.prospective.util.jackson.mode;

import java.util.Date;

/**
 * Created by wanbf on 2018/6/27.
 */
public class TestBean {
    private String name;
    private String course;
    private Date now;
    private Sexy sexy;

    public TestBean(String name, Sexy sexy) {
        this.name = name;
        this.sexy = sexy;
        this.now = new Date();
    }

    public Date getNow() {
        return now;
    }

    public void setNow(Date now) {
        this.now = now;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Sexy getSexy() {
        return sexy;
    }

    public void setSexy(Sexy sexy) {
        this.sexy = sexy;
    }

    public String getCourse() {
        return course;
    }

    public void setCourse(String course) {
        this.course = course;
    }

    @Override
    public String toString() {
        return "TestBean{" +
                "name='" + name + '\'' +
                ", course='" + course + '\'' +
                ", now=" + now +
                ", sexy=" + sexy +
                '}';
    }
}
