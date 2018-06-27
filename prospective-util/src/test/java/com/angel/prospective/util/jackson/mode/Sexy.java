package com.angel.prospective.util.jackson.mode;

/**
 * Created by wanbf on 2018/6/27.
 */
public enum Sexy {
    MEN("男", "M"), WOMEN("女", "W");
    private String text;
    private String code;

    Sexy(String text, String code) {
        this.text = text;
        this.code = code;
    }

    public String getText() {
        return text;
    }

    public String getCode() {
        return code;
    }

    @Override
    public String toString() {
        return "{\"text\":\"" + getText() + "\",\"code\":\"" + getCode() + "\"}";
    }
}
