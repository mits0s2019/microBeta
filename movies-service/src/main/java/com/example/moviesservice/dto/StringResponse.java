package com.example.moviesservice.dto;

import javax.xml.bind.annotation.XmlRootElement;

public class StringResponse {
    private String response;

    public StringResponse(String response) {
        this.response = response;
    }

    public String getResponse() {
        return response;
    }

    public void setResponse(String response) {
        this.response = response;
    }
}
