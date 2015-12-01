/**
 * ============================================================================================================
 * File Name       	: RequestCallbackListener.java
 * Author          	: Apex Team @ Endeavour Software Technologies pvt. ltd., Bangalore.
 * Version         	: 1.0.0
 * Copyright       	: Apex
 * Description     	: This is the interface which receives the request process callback to notify the UI layer.
 * History         	:
 * ============================================================================================================
 *  Sr. No.	    Date		          Name				 Description
 * ============================================================================================================
 *  1.	   	    16.10.2014            Apex Team            Initial Version.
 *  2.                                Apex Team            Check SVN.
 * ============================================================================================================
 */

package com.hackathon.dropbydrop.utils;


import com.hackathon.dropbydrop.data.ResponseDTO;

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
