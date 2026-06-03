package org.template.framework.Utility.Enums;

import org.template.framework.Utility.Annotation.Author;

@Author(name = "Ankit Dwivedi",
        date = "2026-05-22",
        email = "ankitdwivedi46@live.com")
public enum APIConfig {
    BASE_URL("api.baseUrl"),
    PRODUCT_BASE_URL("api.product.baseUrl"),
    PRODUCT_BASE_PATH("api.product.basePath"),
    PAYMENT_BASE_URL("api.payment.baseUrl"),
    PAYMENT_BASE_PATH("api.payment.basePath"),
    TIMEOUT_MS("api.timeoutMs"),
    RELAXED_HTTPS("api.relaxedHttps");

    private final String key;

    APIConfig(String key) {
        this.key = key;
    }

    public String key() {
        return key;
    }
}
