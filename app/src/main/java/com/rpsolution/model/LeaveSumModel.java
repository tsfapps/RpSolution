package com.rpsolution.model;

public class LeaveSumModel {

    private String month;
    private String sickLeave;
    private String casualLeave;
    private String totalLeave;

    public LeaveSumModel(String month, String sickLeave, String casualLeave, String totalLeave) {
        this.month = month;
        this.sickLeave = sickLeave;
        this.casualLeave = casualLeave;
        this.totalLeave = totalLeave;
    }

    public String getMonth() {
        return month;
    }

    public void setMonth(String month) {
        this.month = month;
    }

    public String getSickLeave() {
        return sickLeave;
    }

    public void setSickLeave(String sickLeave) {
        this.sickLeave = sickLeave;
    }

    public String getCasualLeave() {
        return casualLeave;
    }

    public void setCasualLeave(String casualLeave) {
        this.casualLeave = casualLeave;
    }

    public String getTotalLeave() {
        return totalLeave;
    }

    public void setTotalLeave(String totalLeave) {
        this.totalLeave = totalLeave;
    }
}
