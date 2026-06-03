package org.template.framework.Utility.Enums;

import org.template.framework.Utility.Annotation.Author;

@Author(name = "Ankit Dwivedi",
        date = "2026-05-22",
        email = "ankitdwivedi46@live.com")
public enum DBConfig {
    URL("db.url"),
    USERNAME("db.username"),
    PASSWORD("db.password");

    private final String key;

    DBConfig(String key) {
        this.key = key;
    }

    public String key() {
        return key;
    }
}
