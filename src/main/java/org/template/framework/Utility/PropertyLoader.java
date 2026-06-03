package org.template.framework.Utility;

import org.template.framework.Utility.Annotation.Author;

import java.io.InputStream;
import java.util.Map;
import java.util.Properties;
import java.util.concurrent.ConcurrentHashMap;

@Author(name = "Ankit Dwivedi",
        date = "2026-05-22",
        email = "ankitdwivedi46@live.com")
public final class PropertyLoader {

    private PropertyLoader(){}

    public static Properties load(String fileName){

        try{
            InputStream inputStream = Thread.currentThread().getContextClassLoader().getResourceAsStream( fileName);
            if(inputStream==null){
                throw new RuntimeException("Property file not found: " + fileName);
            }
            Properties properties = new Properties();
            properties.load(inputStream);
            return properties;
        } catch (Exception e) {
            throw new RuntimeException("Unable to load file " + fileName + e);
        }
    }

}