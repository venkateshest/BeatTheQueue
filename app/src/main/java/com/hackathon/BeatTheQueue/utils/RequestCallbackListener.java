

package com.hackathon.BeatTheQueue.utils;


import com.hackathon.BeatTheQueue.data.ResponseDTO;

public interface RequestCallbackListener {

	/**
	 * Process the response once response is received from the Connection
	 * handler.
	 */
	void onResponseReceived(ResponseDTO responseData);

	/**
	 * Process the response once errror occurred from the Connection handler.
	 */
	void onError(int code, String message);
}
