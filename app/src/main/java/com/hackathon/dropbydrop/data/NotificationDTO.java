package com.hackathon.dropbydrop.data;

/**
 * Created by venkatesh.kolla on 12/1/2015.
 */
public class NotificationDTO {

    private String name;
    private String bloodGroup;
    private double lat;
    private double longt;
    private String dateTime;
    private String address;
    private String status;
    private int applicationId;
    private String phoneNo;
    private String toTime;

    public void setToTime(String toTime) {
        this.toTime = toTime;
    }

    public void setFromTime(String fromTime) {
        this.fromTime = fromTime;
    }

    public String getToTime() {
        return toTime;
    }

    public String getFromTime() {
        return fromTime;
    }

    private String fromTime;

    public String getPhoneNo() {
        return phoneNo;
    }

    public void setPhoneNo(String phoneNo) {
        this.phoneNo = phoneNo;
    }

    public int getApplicationId() {
        return applicationId;
    }

    public void setApplicationId(int applicationId) {
        this.applicationId = applicationId;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getDate() {
        return dateTime;
    }

    public void setDate(String dateTime) {
        this.dateTime = dateTime;
    }

    public double getLat() {
        return lat;
    }

    public void setLat(double lat) {
        this.lat = lat;
    }

    public double getLongt() {
        return longt;
    }

    public void setLongt(double longt) {
        this.longt = longt;
    }

    public String getBloodGroup() {
        return bloodGroup;
    }

    public void setBloodGroup(String message) {
        this.bloodGroup = message;
    }
}
