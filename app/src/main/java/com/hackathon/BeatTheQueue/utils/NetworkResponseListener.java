
package com.hackathon.BeatTheQueue.utils;


import com.hackathon.BeatTheQueue.data.Response;

public interface NetworkResponseListener {

	/**
	 * Process the response once response is received from the Connection
	 * handler.
	 */
	void onNetworkResponse(Response responseData);

	/**
	 * Process the response once errror occurred from the Connection handler.
	 */
	void onNetworkError(Response responseData);

}
