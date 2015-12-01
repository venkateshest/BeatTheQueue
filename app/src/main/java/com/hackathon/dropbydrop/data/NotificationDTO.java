package com.hackathon.dropbydrop.data;

/**
 * Created by venkatesh.kolla on 12/1/2015.
 */
public class NotificationDTO {

    private String name;
    private String bloodGroup;
    private double lat;
    private double longt;
    private long dateTime;
    private String address;
    private String status;
    private int applicationId;
    private String phoneNo;

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

    public double getDateTime() {
        return dateTime;
    }

    public void setDateTime(long dateTime) {
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
