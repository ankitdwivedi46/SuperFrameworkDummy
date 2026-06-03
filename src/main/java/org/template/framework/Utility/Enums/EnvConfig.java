package org.template.framework.Utility.Enums;

import org.template.framework.Utility.Annotation.Author;

@Author(name = "Ankit Dwivedi",
        date = "2026-05-22",
        email = "ankitdwivedi46@live.com")
public enum EnvConfig {
    QA("qa"),
    DEV("dev"),
    PROD("prod");

    private final String key;

    EnvConfig(String key) {
        this.key = key;
    }

    public String key() {
        return key;
    }
}
