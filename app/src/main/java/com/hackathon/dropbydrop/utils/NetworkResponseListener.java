
package com.hackathon.dropbydrop.utils;


import com.hackathon.dropbydrop.data.Response;

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
