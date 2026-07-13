package com.example.book_spring.globalhandler;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class ResourceNotFoundException extends RuntimeException {
    private int code;
    private String message;

    public ResourceNotFoundException() {
        this.code = 404;
        this.message = "Resource Not Found";
    }

}
