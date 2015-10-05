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

}
