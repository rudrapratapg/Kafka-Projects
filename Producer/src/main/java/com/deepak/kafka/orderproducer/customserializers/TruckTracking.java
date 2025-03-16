package com.deepak.kafka.orderproducer.customserializers;

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

	public String getLongitude() {
		return longitude;
	}

	public String getLatitude() {
		return latitude;
	}

	private TruckTracking(Builder builder) {
		this.uniqueId = builder.uniqueId;
		this.latitude = builder.latitude;
		this.longitude = builder.longitude;
	}
	
	public static class Builder {
		private int uniqueId;
		private String longitude;
		private String latitude;
		
		public Builder setUniqueId(int uniqueId) {
			this.uniqueId = uniqueId;
			return this;
		}
		public Builder setLongitude(String longitude) {
			this.longitude = longitude;
			return this;
		}
		public Builder setLatitude(String latitude) {
			this.latitude = latitude;
			return this;
		}
		public TruckTracking build() {
			return new TruckTracking(this);
		}
	}
	

}
