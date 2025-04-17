package com.meteo.model;

import java.sql.Timestamp;

public class Signalement {
    private int id;
    private double latitude;
    private double longitude;
    private String temps;
    private double temperature;
    private Timestamp horodatage;

    // Constructeur
    public Signalement(double latitude, double longitude, String temps, double temperature) {
        this.latitude = latitude;
        this.longitude = longitude;
        this.temps = temps;
        this.temperature = temperature;
    }

    // Getters et Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public String getTemps() {
        return temps;
    }

    public void setTemps(String temps) {
        this.temps = temps;
    }

    public double getTemperature() {
        return temperature;
    }

    public void setTemperature(double temperature) {
        this.temperature = temperature;
    }

    public Timestamp getHorodatage() {
        return horodatage;
    }

    public void setHorodatage(Timestamp horodatage) {
        this.horodatage = horodatage;
    }
}
