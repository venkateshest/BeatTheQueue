package com.hackathon.dropbydrop.data;

public class LocCoordinates {

	private double latitude;
	
	private double longitude;
	
	public LocCoordinates(final double latitude, final double longitude) {
		this.latitude = latitude;
		this.longitude = longitude;
	}

	public double getLatitude() {
		return latitude;
	}

	public void setLatitude(final double latitude) {
		this.latitude = latitude;
	}

	public double getLongitude() {
		return longitude;
	}

	public void setLongitude(final double longitude) {
		this.longitude = longitude;
	}
	
}
