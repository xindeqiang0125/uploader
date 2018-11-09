package com.github.xindeqiang0125.uploader;

public class ResultData {
    private String status;
    private String reason;
    private String[] urls;

    private ResultData(String status, String reason, String[] urls) {
        this.status = status;
        this.reason = reason;
        this.urls = urls;
    }

    public static ResultData success(String[] urls){
        return new ResultData("success",null,urls);
    }

    public static ResultData failure(String reason){
        return new ResultData("failure",reason,null);
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public String[] getUrls() {
        return urls;
    }

    public void setUrls(String[] urls) {
        this.urls = urls;
    }
}
