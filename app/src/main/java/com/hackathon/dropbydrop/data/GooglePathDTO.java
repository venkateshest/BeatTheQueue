package com.hackathon.dropbydrop.data;

import java.util.ArrayList;
import java.util.List;

import com.google.android.gms.maps.model.LatLng;

public class GooglePathDTO {

	private String encodedString;
	private LocCoordinates northEast;
	private LocCoordinates southWest;
	private ArrayList<String> points;
	private List<LatLng> routeLine;

	public GooglePathDTO(final String encodedString, final LocCoordinates northEast, final LocCoordinates southWest,
			final ArrayList<String> points, List<LatLng> routeLine) {
		super();
		this.encodedString = encodedString;
		this.northEast = northEast;
		this.southWest = southWest;
		this.points = points;
		this.setRouteLine(routeLine);
	}

	public LocCoordinates getNorthEast() {
		return northEast;
	}

	public void setNorthEast(final LocCoordinates northEast) {
		this.northEast = northEast;
	}

	public LocCoordinates getSouthWest() {
		return southWest;
	}

	public void setSouthWest(final LocCoordinates southWest) {
		this.southWest = southWest;
	}

	public ArrayList<String> getPoints() {
		return points;
	}

	public void setPoints(final ArrayList<String> points) {
		this.points = points;
	}

	public String getEncodedString() {
		return encodedString;
	}

	public void setEncodedString(final String encodedString) {
		this.encodedString = encodedString;
	}

	public List<LatLng> getRouteLine() {
		return routeLine;
	}

	public void setRouteLine(List<LatLng> routeLine) {
		this.routeLine = routeLine;
	}

}
