package com.store.exceptionhandler;

import lombok.Getter;

@Getter
public enum ProblemType {

    INVALID_DATA("Invalid data"),
    ACCESS_DENIED("Access denied"),
    SYSTEM_ERROR("System error"),
    INVALID_PARAMETER("Invalid parameter"),
    INCOMPREHENSIBLE_MESSAGE("Incomprehensible message"),
    RESOURCE_NOT_FOUND("Resource not found"),
    ENTITY_IN_USE("Entity in use"),
    ENTITY_EXISTS("Already exists a entity with this name");

    private final String title;
    ProblemType(String title) {
        this.title = title;
    }
}
