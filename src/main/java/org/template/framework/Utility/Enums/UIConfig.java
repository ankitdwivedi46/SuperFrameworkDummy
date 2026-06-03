package org.template.framework.Utility.Enums;

import org.template.framework.Utility.Annotation.Author;

@Author(name = "Ankit Dwivedi",
        date = "2026-05-22",
        email = "ankitdwivedi46@live.com")
public enum UIConfig {
    BASE_URL("ui.baseUrl"),
    BROWSER("ui.browser"),
    HEADLESS("ui.headless"),
    IMPLICIT_WAIT_SEC("ui.implicitWaitSec"),
    PAGE_LOAD_TIMEOUT_SEC("ui.pageLoadTimeoutSec");

    private final String key;

    UIConfig(String key) {
        this.key = key;
    }

    public String key() {
        return key;
    }
}
