package com.example.websocketrabbitmqdemo.utils.responseinfo;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.HashMap;
import java.util.Map;

public class ResponseInfo {

    @JsonProperty("data")
    private Map<String, Object> data;

    @JsonProperty("status")
    private Status status;

    public ResponseInfo() {
        this.data = new HashMap<>();
        this.status = new Status();
    }

    public Map<String, Object> getData() {
        return data;
    }

    public void setData(Map<String, Object> data) {
        this.data = data;
    }

    public void putData(String key, Object d) {
        this.data.put(key, d);
    }

    public void putData(Map<String, Object> data) {
        this.data.putAll(data);
    }

    public Status getStatus() {
        return status;
    }

    public static class Status {

        @JsonProperty("code")
        private String code;

        public String getCode() {
            return code;
        }

        public void setCode(String code) {
            this.code = code;
        }

    }
}
