package com.nengjun.hex.crawler;

import java.io.File;
import java.util.Set;

/**
 * Created by Henry on 16/1/23.
 */
public class Page {
    private Request request;
    private int statusCode;
    private String html;
    private Set<Request> newRequests;

    @Override
    public String toString() {
        return "Page{" +
                "statusCode=" + statusCode +
                ", html='" + html + '\'' +
                '}';
    }

    public String getFileName() {
        File file = new File(request.getUrl());
        String name = file.getName();
        return String.format("%s.htm", name.split("\\.")[0]);
    }

    public Request getRequest() {
        return request;
    }

    public void setRequest(Request request) {
        this.request = request;
    }

    public int getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(int statusCode) {
        this.statusCode = statusCode;
    }

    public String getHtml() {
        return html;
    }

    public void setHtml(String html) {
        this.html = html;
    }

    public Set<Request> getNewRequests() {
        return newRequests;
    }

    public void setNewRequests(Set<Request> newRequests) {
        this.newRequests = newRequests;
    }
}
