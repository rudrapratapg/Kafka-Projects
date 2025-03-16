package com.deepak.kafka.orderconsumer.customdeserializers;


public class TruckTracking {
	
	private int uniqueId;
	private String longitude;
	private String latitude;
	
	@Override
	public String toString() {
		return "TruckTracking [uniqueId=" + uniqueId + ", longitude=" + longitude + ", latitude=" + latitude + "]";
	}

	public int getUniqueId() {
		return uniqueId;
	}

	public void setUniqueId(int uniqueId) {
		this.uniqueId = uniqueId;
	}

	public String getLongitude() {
		return longitude;
	}

	public void setLongitude(String longitude) {
		this.longitude = longitude;
	}

	public String getLatitude() {
		return latitude;
	}

	public void setLatitude(String latitude) {
		this.latitude = latitude;
	}
	
	
}
