package com.nengjun.hex.crawler;

public class Request {
    private Integer id;

    private String source;

    private String url;

    private Byte status;

    private Byte number;

    public Request() {
    }

    public Request(String source, String url) {
        this.source = source;
        this.url = url;
    }

    @Override
    public String toString() {
        return "Request{" +
                "id=" + id +
                ", source='" + source + '\'' +
                ", url='" + url + '\'' +
                ", status=" + status +
                ", number=" + number +
                '}';
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source == null ? null : source.trim();
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url == null ? null : url.trim();
    }

    public Byte getStatus() {
        return status;
    }

    public void setStatus(Byte status) {
        this.status = status;
    }

    public Byte getNumber() {
        return number;
    }

    public void setNumber(Byte number) {
        this.number = number;
    }
}
