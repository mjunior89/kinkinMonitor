package br.hue.hue.inf008.kinkinmonitor.utils;

public class PontoLocalizacao {

	private int latitude, longitude;

	public PontoLocalizacao() {
		this(0, 0);
	}

	public PontoLocalizacao(int latitude, int longitude) {
		this.latitude = latitude;
		this.longitude = longitude;
	}

	public int getLatitude() {
		return latitude;
	}

	public void setLatitude(int latitude) {
		this.latitude = latitude;
	}

	public int getLongitude() {
		return longitude;
	}

	public void setLongitude(int longitude) {
		this.longitude = longitude;
	}

	@Override
	public String toString() {
		return latitude + "Lat., " + longitude + "Long.";
	}

	@Override
	public boolean equals(Object obj) {
		if (!(obj instanceof PontoLocalizacao)) {
			return false;
		}
		PontoLocalizacao other = (PontoLocalizacao) obj;
		int latitudeResult = Integer.compare(this.getLatitude(), other.getLatitude());
		int longitudeResult = Integer.compare(this.getLongitude(), other.getLongitude());
		return latitudeResult == 0 && longitudeResult == 0;
	}

	@Override
	public int hashCode() {
		Integer hash = 7;
		hash = (31 * hash) + this.getLatitude();
		hash = (31 * hash) + this.getLatitude();
		return hash;
	}

}
