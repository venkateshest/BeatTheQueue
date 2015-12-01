/**
 * ============================================================================================================
 * File Name       	: Response.java
 * Author          	: Apex Team @ Endeavour Software Technologies pvt. ltd., Bangalore.
 * Version         	: 1.0.0
 * Copyright       	: Endeavour
 * Description     	: This is POJO class which holds the response data
 * History         	:
 * ============================================================================================================
 *  Sr. No.	    Date		          Name				 Description
 * ============================================================================================================
 *  1.	   	    16.10.2014           Apex Team            Initial Version.
 *  2.                               Apex Team            Check SVN.
 * ============================================================================================================
 */

package com.hackathon.dropbydrop.data;

import org.json.JSONObject;

public class Response {

	private int responseCode;

	private String responseMessage;

	private JSONObject responseObject;

	public int getResponseCode() {
		return responseCode;
	}

	public void setResponseCode(final int responseCode) {
		this.responseCode = responseCode;
	}

	public String getResponseMessage() {
		return responseMessage;
	}

	public void setResponseMessage(final String responseMessage) {
		this.responseMessage = responseMessage;
	}

	public JSONObject getResponseObject() {
		return responseObject;
	}

	public void setResponseObject(final JSONObject responseObject) {
		this.responseObject = responseObject;
	}
}
