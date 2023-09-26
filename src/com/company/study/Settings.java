package com.company.study;

public class Settings {
    private Settings() {};
    //static 인스턴스 선언
    private static class SettingsHolder {
        private static final Settings INSTANCE = new Settings();
    }

    public static synchronized Settings getInstance() {
        return SettingsHolder.INSTANCE;
    }
}