package com.hackathon.BeatTheQueue;

import android.app.Application;
import android.content.Context;


/**
 * Created by venkatesh.kolla
 */
public class BTQApplication extends Application {

    public static Context mContext;

    @Override
    public void onCreate() {
        super.onCreate();

        mContext=this;

    }

}
