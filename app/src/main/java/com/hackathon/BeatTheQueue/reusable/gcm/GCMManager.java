package com.hackathon.BeatTheQueue.reusable.gcm;

import android.content.Context;
import android.os.AsyncTask;

import com.google.android.gms.gcm.GoogleCloudMessaging;
import com.hackathon.BeatTheQueue.repo.BTQSharedPreferences;
import com.hackathon.BeatTheQueue.reusable.constants.StringConstants;

import java.io.IOException;

public class GCMManager {
    private GoogleCloudMessaging mGCM;
    private String mRegID;

    public void registerToGCM(final Context context) {
        new AsyncTask<Void, Void, String>() {
            @Override
            protected String doInBackground(Void... params) {
                String msg = "";
                try {
                    if (mGCM == null) {
                        mGCM = GoogleCloudMessaging.getInstance(context);
                    }
                    mRegID = mGCM.register(StringConstants.GCM_SENDER_ID);
                    msg = "Device registered, registration ID=" + mRegID;

                    // For this demo: we don't need to send it because the device will send
                    // upstream messages to a server that echo back the message using the
                    // 'from' address in the message.

                    // Persist the regID - no need to register again.
                    storeRegistrationId(context, mRegID);
                } catch (IOException e) {
                    e.printStackTrace();
                }
                return msg;
            }

            @Override
            protected void onPostExecute(String msg) {
                return;
            }
        }.execute(null, null, null);
    }

    private void storeRegistrationId(Context context, String regId) {
        BTQSharedPreferences BTQSharedPreferences = new BTQSharedPreferences(context);
        BTQSharedPreferences.putString(StringConstants.PREF_GCM_REG_ID, regId);
    }
}
