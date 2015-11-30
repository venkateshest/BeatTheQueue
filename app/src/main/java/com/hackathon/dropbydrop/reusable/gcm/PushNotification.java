package com.hackathon.dropbydrop.reusable.gcm;

import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.AsyncTask;
import android.preference.PreferenceManager;
import android.util.Log;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TimePicker;
import android.widget.Toast;

import com.hackathon.dropbydrop.reusable.constants.StringConstants;
import com.hackathon.dropbydrop.utils.NetworkUtils;

import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicHeader;
import org.apache.http.protocol.HTTP;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.UnsupportedEncodingException;

public class PushNotification {

    private static final String TAG = "PushNotification";
    private JSONObject mJsonObject;
    private JSONArray mDeviceRegIDs;

    public PushNotification (JSONObject jsonObject, JSONArray regIDs) {
        this.mJsonObject = jsonObject;
        this.mDeviceRegIDs = regIDs;
    }

    AsyncTask<Void, Void, Void> sendPushTask = new AsyncTask<Void, Void, Void>() {
        @Override
        protected Void doInBackground(Void... params) {
            connect(mJsonObject, mDeviceRegIDs);
            return null;
        }

        @Override
        protected void onPostExecute(Void aVoid) {
            Log.i(TAG, "Pust Sent");
        }
    };

    public void sendPush() {
        sendPushTask.execute();
    }

    private void connect(JSONObject jsonObject, JSONArray deviceRegistrationIDs) {

        Log.e("TAG", "Creating HTTP Connection");

        // Creating HTTP client
        HttpClient httpClient = new DefaultHttpClient();
        // Creating HTTP Post
        HttpPost httpPost = new HttpPost("https://android.googleapis.com/gcm/send");

        Log.i(TAG, " HTTP Connection created");

        JSONObject pushMessage = null;
        try {
            /*JSONArray regIds = new JSONArray();
            regIds.put(<device registration id here>);*/
            pushMessage = new JSONObject();
            //pushMessage.put("delay_while_idle", false);
            pushMessage.put("data", jsonObject);
            pushMessage.put("registration_ids", deviceRegistrationIDs);

        } catch (JSONException e1) {
            e1.printStackTrace();
        }

		/*
		 * nameValuePair.add(new BasicNameValuePair("registration_id", regId));
		 */
        System.out.println("====Value====" + pushMessage);
        // Url Encoding the POST parameters
        try {
            httpPost.setHeader("Authorization", "key="+StringConstants.GCM_SERVER_KEY);
            httpPost.setHeader("Content-Type", "application/json");

            StringEntity se = new StringEntity(pushMessage.toString());
            se.setContentEncoding(new BasicHeader(HTTP.CONTENT_TYPE, "application/json"));
            httpPost.setEntity(se);
            Log.i(TAG, "Data send");
        } catch (UnsupportedEncodingException e) {
            // writing error to Log
            e.printStackTrace();
        }

        // Making HTTP Request
        try {
            HttpResponse response = httpClient.execute(httpPost);
            int responseCode = response.getStatusLine().getStatusCode();
            String responseMsg = response.getStatusLine().getReasonPhrase().toString();

            Log.d("Http Response Code:", ""+responseCode);
            // writing response to log
            Log.d("Http Response:", responseMsg);
        } catch (ClientProtocolException e) {
            // writing exception to log
            e.printStackTrace();
        } catch (IOException e) {
            // writing exception to log
            e.printStackTrace();

        }
    }


}