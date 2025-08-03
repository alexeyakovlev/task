package com.yakovlev.task.util.exception;

/**
 * Created by alexi on 03.08.2025
 */
public record ErrorResponce(String error, String message) {
    @Override
    public String toString() {
        return "Error: " + error + "\n" + "Message: " + message;
    }
}
