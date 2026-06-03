package org.template.framework.Utility.BackEnd;

import org.template.framework.Utility.Annotation.Author;

import java.util.HashMap;
import java.util.Map;

@Author(name = "Ankit Dwivedi",
        date = "2026-05-22",
        email = "ankitdwivedi46@live.com")
public class BackEndUtils {

    public static Map<String,String> setCommonApiHeaders(){
        Map<String,String> map = new HashMap<>();
        map.put("Content-Type","application/json");
        return map;
    }

}
