package br.com.violencia.sp;

import br.com.violencia.sp.enums.Delegacy;

public class Local {
	
	public Local(double latitude, double longitude) {
		this.latitude = latitude;
		this.longitude = longitude;
	}
	
	private double latitude;
	
	private double longitude;
	
	public Delegacy getTheNearestDelegacy() {
		double[] distances = new double[Delegacy.values().length];
		for (int i = 0; i < Delegacy.values().length; i++) {
			distances[i] =  Distance.betweenPoints(latitude, longitude, Delegacy.values()[i].getLatitude(), Delegacy.values()[i].getLongitude());
		}
		
		return Delegacy.values()[Distance.smallestValueIndex(distances)];
	}

	public double getLatitude() {
		return latitude;
	}

	public void setLatitude(double latitude) {
		this.latitude = latitude;
	}

	public double getLongitude() {
		return longitude;
	}

	public void setLongitude(double longitude) {
		this.longitude = longitude;
	}
}
