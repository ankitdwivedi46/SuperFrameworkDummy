package org.template.framework.Utility;

import org.template.framework.Utility.Annotation.Author;
import org.template.framework.Utility.Enums.EnvConfig;

@Author(name = "Ankit Dwivedi",
        date = "2026-05-22",
        email = "ankitdwivedi46@live.com")
public class Environment {

    private static final String ENV;

    static {

        String env = System.getProperty("env");
        if(env == null){
            env = PropertyLoader.load("framework.properties").getProperty("env", EnvConfig.QA.key());
        }

        ENV = env.toLowerCase();

    }

    private Environment(){}

    public static String get(){
        return ENV;
    }

}
