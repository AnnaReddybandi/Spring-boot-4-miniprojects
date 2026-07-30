package com.example.studentcourseregistration.payload;

import java.time.LocalDateTime;

public class ApiResponse {

    private LocalDateTime timestamp;

    private Integer status;

    private String message;

    private Object data;

    public ApiResponse() {
    }

    public ApiResponse(LocalDateTime timestamp,
                       Integer status,
                       String message,
                       Object data) {

        this.timestamp = timestamp;
        this.status = status;
        this.message = message;
        this.data = data;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(LocalDateTime timestamp) {
        this.timestamp = timestamp;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

}