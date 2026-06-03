package org.template.framework.Utility.Enums;

import org.template.framework.Utility.Annotation.Author;

@Author(name = "Ankit Dwivedi",
        date = "2026-05-22",
        email = "ankitdwivedi46@live.com")
public enum FrameWorkConfig {

    ENV("env"),
    THREAD_COUNT("thread.count"),
    RETRY_COUNT("retry.count");


    private final String key;

    FrameWorkConfig(String key){
        this.key = key;
    }

    public String key(){
        return key;
    }


}
