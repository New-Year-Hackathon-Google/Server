package com.server.backyaserver.domain.healthStatus.domain;

public enum Status {

    GOOD("좋음"),
    FINE("양호"),
    WARNING("주의"),
    DANGER("위험"),
    ;

    private final String value;

    Status(String value) {
        this.value = value;
    }
}
