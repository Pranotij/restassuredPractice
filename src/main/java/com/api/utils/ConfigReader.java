package com.api.utils;

import groovy.util.logging.Log;

import java.io.InputStream;
import java.util.Properties;

import static utils.ApiLogger.logInfo;

public class ConfigReader {

        private static Properties properties = new Properties();

        static {
            try {
                InputStream input = ConfigReader.class
                        .getClassLoader()
                        .getResourceAsStream("config.properties");

                properties.load(input);

            } catch (Exception e) {
                throw new RuntimeException("Failed to load config.properties");
            }
        }

        public static String getBaseUrl() {
            return properties.getProperty("base.url");
        }

        public static String getApiKey() {
           String apiKey=  properties.getProperty("apiKey");

            return  apiKey.toString();
        }
    }


