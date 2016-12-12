
package com.hackathon.BeatTheQueue.data;

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
