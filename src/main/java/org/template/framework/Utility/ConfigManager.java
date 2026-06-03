package org.template.framework.Utility;

import org.openqa.selenium.Keys;
import org.template.framework.Utility.Annotation.Author;
import org.template.framework.Utility.Enums.EnvConfig;

import java.util.Arrays;
import java.util.Locale;
import java.util.Properties;

@Author(name = "Ankit Dwivedi",
        date = "2026-05-22",
        email = "ankitdwivedi46@live.com")
public class ConfigManager {

    private static final Properties PROPS;

    static{
        String envFileName = EnvConfig.valueOf(Environment.get().toUpperCase(Locale.ROOT))+".properties";
        PROPS = PropertyLoader.load(envFileName);
    }

    public static String toEnvKey(String key){

        String[] keyList = key.split("\\.");
        if(keyList.length<2){
            return key;
        }
        return keyList[0]+"."+Environment.get()+"."+String.join(".", Arrays.copyOfRange(keyList,1,keyList.length));

    }

    public static String configKeyToString(Enum<?> enumKey){
        return enumKey.name()!=null?enumKeyToStringValue(enumKey):null;
    }

    public static String enumKeyToStringValue(Enum<?> enumKey){
        try{
            return enumKey.getClass().getMethod("key").invoke(enumKey).toString();
        } catch (Exception e) {
            throw new RuntimeException("No Key Found in Enum" + enumKey + e);
        }
    }

    public static String get(String key){
        String value = System.getProperty(key);
        if(isValid(value)){
            return value;
        }
        value = PROPS.getProperty(toEnvKey(key));
        if(isValid(value)){
            return value;
        }
        value = PROPS.getProperty(key);
        if(isValid(value)){
            return value;
        }
        throw new RuntimeException("Config Key : "+key+" Not Found. Tried with : "+ toEnvKey(key) + " and "+ key);
    }


    public static boolean isValid(String value){
        return value!=null && !value.isBlank() && !value.isBlank();
    }

    public static String get(Enum<?> enumKey){
        return get(configKeyToString(enumKey));
    }

}
