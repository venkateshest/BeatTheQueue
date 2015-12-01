package com.hackathon.dropbydrop;

import android.app.Application;
import android.content.Context;

import com.hackathon.dropbydrop.data.NotificationDTO;
import com.hackathon.dropbydrop.utils.GPSTracker;

import java.util.ArrayList;
import java.util.Date;

/**
 * Created by venkatesh.kolla on 12/1/2015.
 */
public class DropByDropApplication extends Application {

    public static ArrayList<NotificationDTO> mVanNotifications= new ArrayList<>();
    public static ArrayList<NotificationDTO> mUserNotifications= new ArrayList<>();

    // GPS Location
   public static GPSTracker gps;
    public static final double US_LAT = 37.09024;
    public static final double US_LONG = -95.712891;
    public static double currentLat = US_LAT;
    public static double currentLong = US_LONG;
    public static Context mContext;

    @Override
    public void onCreate() {
        super.onCreate();
        addDummyDataforNotifications();
        addDummyDataforVanNotifications();
        mContext=this;

    }
    public static void addDummyDataforVanNotifications(){
        NotificationDTO date;
        date= new NotificationDTO();

        date.setName("Venkatesh");
        date.setAddress("3rd cross,Manjunatha layout,marathahalli");
        date.setPhoneNo("+91-9538567845");
        date.setBloodGroup("Need B+ve blood donor");
        date.setLat(12.9511982);
        date.setLongt(77.6997663);
        date.setDate(new Date().getTime() - 10000+"");
        date.setStatus("pending");
        mVanNotifications.add(date);

        date.setName("Venkatesh");
        date.setAddress("3rd cross,Manjunatha layout,marathahalli");
        date.setPhoneNo("+91-9538567845");
        date.setBloodGroup("Need B+ve blood donor");
        date.setLat(12.9511982);
        date.setLongt(77.6997663);
        date.setDate(new Date().getTime() - 30000+"");
        date.setStatus("completed");
        mVanNotifications.add(date);

        date= new NotificationDTO();
        date.setName("Srikanth");
        date.setAddress("882 & 883, 8th Main Road, J P Nagar 3rd Phase, ");
        date.setPhoneNo("+91-9534555555");
        date.setBloodGroup("Need O+ve blood donor");
        date.setLat(12.910491);
        date.setStatus("pending");
        date.setLongt(77.5857168);
        date.setDate(new Date().getTime() - 20000+"");
        mVanNotifications.add(date);

        date= new NotificationDTO();
        date.setName("Iqbal");
        date.setAddress("Service Road, Green Glen Layout,Bangalore");
        date.setPhoneNo("+91-9538444445");
        date.setBloodGroup("Need B+ve blood donor");
        date.setLat(12.9511982);
        date.setStatus("pending");
        date.setLongt(77.6997663);
        date.setDate(new Date().getTime() - 10000+"");
        mVanNotifications.add(date);

        date= new NotificationDTO();
        date.setName("Divya");
        date.setAddress("Manjunatha layout,silk board");
        date.setPhoneNo("+91-9538434545");
        date.setBloodGroup("Need AB+ve blood donor");
        date.setLat(12.9172106);
        date.setStatus("Completed");
        date.setLongt(77.6228464);
        date.setDate(new Date().getTime() - 10000+"");
        mVanNotifications.add(date);

        date= new NotificationDTO();
        date.setName("Goutham");
        date.setAddress("3rd cross,Jp nager layout");
        date.setPhoneNo("+91-9537896945");
        date.setBloodGroup("Need B+ve blood donor");
        date.setLat(12.9511982);
        date.setStatus("pending");
        date.setLongt(77.6997663);
        date.setDate(new Date().getTime() - 10000+"");
        mVanNotifications.add(date);

        date= new NotificationDTO();
        date.setName("Goutham");
        date.setAddress("3rd cross,Jp nager layout");
        date.setPhoneNo("+91-9537896945");
        date.setBloodGroup("Need B+ve blood donor");
        date.setLat(12.9511982);
        date.setStatus("Re-scheduled");
        date.setLongt(77.6997663);
        date.setDate(new Date().getTime() - 10000+"");
        mVanNotifications.add(date);

        date= new NotificationDTO();
        date.setName("Ganapathi");
        date.setAddress("4th main,jaya nager,Bangalore");
        date.setPhoneNo("+91-9538473456");
        date.setBloodGroup("Need B+ve blood donor");
        date.setLat(12.9329463);
        date.setStatus("Completed");
        date.setLongt(77.5838692);
        date.setDate(new Date().getTime() - 10000+"");
        mVanNotifications.add(date);

        date= new NotificationDTO();
        date.setName("Ganapathi");
        date.setAddress("4th main,jaya nager,Bangalore");
        date.setPhoneNo("+91-9538473456");
        date.setBloodGroup("Need B+ve blood donor");
        date.setLat(12.9329463);
        date.setStatus("Re-scheduled");
        date.setLongt(77.5838692);
        date.setDate(new Date().getTime() - 10000+"");
        mVanNotifications.add(date);

    }
    public static void addDummyDataforNotifications(){
        NotificationDTO date;

        date= new NotificationDTO();
        date.setName("Venkatesh");
        date.setAddress("3rd cross,Manjunatha layout,marathahalli");
        date.setPhoneNo("+91-9538567845");
        date.setBloodGroup("Need B+ve blood donor");
        date.setLat(12.9511982);
        date.setLongt(77.6997663);
        date.setDate(new Date().getTime() - 10000+"");
        date.setStatus("pending");
        mVanNotifications.add(date);

        date= new NotificationDTO();
        date.setName("Goutham");
        date.setAddress("3rd cross,Jp nager layout");
        date.setPhoneNo("+91-9537896945");
        date.setBloodGroup("Need B+ve blood donor");
        date.setLat(12.9511982);
        date.setStatus("pending");
        date.setLongt(77.6997663);
        date.setDate(new Date().getTime() - 10000+"");
        mVanNotifications.add(date);

        date= new NotificationDTO();
        date.setName("Iqbal");
        date.setAddress("Service Road, Green Glen Layout,Bangalore");
        date.setPhoneNo("+91-9538444445");
        date.setBloodGroup("Need B+ve blood donor");
        date.setLat(12.9511982);
        date.setStatus("pending");
        date.setLongt(77.6997663);
        date.setDate(new Date().getTime() - 10000+"");
        mVanNotifications.add(date);
    }
    public static void getCurrentLocation() {
        gps = new GPSTracker(mContext);
        if (gps.canGetLocation()) {

            currentLat = gps.getLatitude();
            currentLong = gps.getLongitude();

        }
    }
}
