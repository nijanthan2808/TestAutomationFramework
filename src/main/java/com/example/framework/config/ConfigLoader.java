package com.example.framework.config;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public final class ConfigLoader {
    private static final Properties PROPS = new Properties();

    static {
        String configPath = System.getProperty("config.file", "src/test/resources/config.properties");
        try (FileInputStream input = new FileInputStream(configPath)) {
            PROPS.load(input);
        } catch (IOException e) {
            throw new RuntimeException("Failed to load config: " + configPath, e);
        }
    }

    private ConfigLoader() {
    }

    public static String get(String key) {
        return PROPS.getProperty(key);
    }

    public static String getOrDefault(String key, String defaultValue) {
        return PROPS.getProperty(key, defaultValue);
    }
}
