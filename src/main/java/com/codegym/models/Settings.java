package com.codegym.models;

public class Settings {
    private boolean notificationEnabled;
    private String theme;

    public Settings() {
    }

    public Settings(boolean notificationEnabled, String theme) {
        this.notificationEnabled = notificationEnabled;
        this.theme = theme;
    }

    public boolean isNotificationEnabled() {
        return notificationEnabled;
    }

    public void setNotificationEnabled(boolean notificationEnabled) {
        this.notificationEnabled = notificationEnabled;
    }

    public String getTheme() {
        return theme;
    }

    public void setTheme(String theme) {
        this.theme = theme;
    }
}
