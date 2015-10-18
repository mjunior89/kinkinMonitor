package br.hue.hue.inf008.kinkinmonitor.utils;

public class PontoLocalizacao {

	private double latitude, longitude;

	public PontoLocalizacao() {
		this(0d, 0d);
	}

	public PontoLocalizacao(double latitude, double longitude) {
		this.latitude = latitude;
		this.longitude = longitude;
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

	@Override
	public boolean equals(Object obj) {
		if (!(obj instanceof PontoLocalizacao)) {
			return false;
		}
		PontoLocalizacao other = (PontoLocalizacao) obj;
		int latitudeResult = Double.compare(this.getLatitude(), other.getLatitude());
		int longitudeResult = Double.compare(this.getLongitude(), other.getLongitude());
		return latitudeResult == 0 && longitudeResult == 0;
	}

	@Override
	public int hashCode() {
		Double hash = 7d;
		hash = (31d * hash) + this.getLatitude();
		hash = (31d * hash) + this.getLatitude();
		return hash.intValue();
	}

}
