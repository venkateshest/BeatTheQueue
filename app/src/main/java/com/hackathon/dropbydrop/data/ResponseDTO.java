/**
 * ============================================================================================================
 * File Name       	: ResponseDTO.java
 * Author          	: Apex Team @ Endeavour Software Technologies pvt. ltd., Bangalore.
 * Version         	: 1.0.0
 * Copyright       	: Apex
 * Description     	: This is the base POJO class. It holds the common response details which can come for any request
 * History         	:
 * ============================================================================================================
 *  Sr. No.	    Date		          Name				 Description
 * ============================================================================================================
 *  1.	   	    16.10.2014           Apex Team            Initial Version.
 *  2.                               Apex Team            Check SVN.
 * ============================================================================================================
 */

package com.hackathon.dropbydrop.data;

import java.util.List;

public class ResponseDTO {

	private List<String> actionErrors;

	private boolean loginRequired;

	private boolean isSuccess;

	private Object responseObj;

	public List<String> getActionErrors() {
		return actionErrors;
	}

	public void setActionErrors(final List<String> actionErrors) {
		this.actionErrors = actionErrors;
	}

	public boolean isLoginRequired() {
		return loginRequired;
	}

	public void setLoginRequired(final boolean loginRequired) {
		this.loginRequired = loginRequired;
	}

	public boolean isSuccess() {
		return isSuccess;
	}

	public void setSuccess(final boolean isSuccess) {
		this.isSuccess = isSuccess;
	}

	public String getErrorMsg() {
		if (actionErrors != null) {
			return actionErrors.get(0);
		}
		return "";
	}

	public Object getResponseObj() {
		return responseObj;
	}

	public void setResponseObj(final Object responseObj) {
		setSuccess(true);
		this.responseObj = responseObj;
	}

}
