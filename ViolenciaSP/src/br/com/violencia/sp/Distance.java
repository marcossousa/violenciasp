package br.com.violencia.sp;

public class Distance {

	public static double betweenPoints(double lat1, double lon1, double lat2,
			double lon2) {
		return betweenPoints(lat1, lon1, lat2, lon2, 'K');
	}

	public static double betweenPoints(double lat1, double lon1, double lat2,
			double lon2, char unit) {
		double theta = lon1 - lon2;
		double dist = Math.sin(deg2rad(lat1)) * Math.sin(deg2rad(lat2))
				+ Math.cos(deg2rad(lat1)) * Math.cos(deg2rad(lat2))
				* Math.cos(deg2rad(theta));
		dist = Math.acos(dist);
		dist = rad2deg(dist);
		dist = dist * 60 * 1.1515;
		if (unit == 'K') {
			dist = dist * 1.609344;
		} else if (unit == 'N') {
			dist = dist * 0.8684;
		}
		return (dist);
	}

	private static double deg2rad(double deg) {
		return (deg * Math.PI / 180.0);
	}

	private static double rad2deg(double rad) {
		return (rad * 180.0 / Math.PI);
	}

	public static double smallest(double... a) {
		double min = a[0];
		for (double i : a) {
			if (i < min) {
				min = i;
			}
		}
		return min;
	}

	public static int smallestValueIndex(double... a) {
		double min = a[0];
		int index = 0;
		for (int i = 0; i < a.length; i++) {
			if (a[i] < min) {
				min = a[i];
				index = i;
			}
		}
		return index;
	}

}
