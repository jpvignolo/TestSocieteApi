package com.yeti.testsocieteapi.data;

/**
 * Created by jp on 02/06/16.
 */
public class Societe {
    private String id;
    private int registrationNumber; // siret
    private String name;
    private String activity;
    private String address;
    private double lng;
    private double lat;

    public Societe() {}

    public Societe(String id, int registrationNumber, String name, String activity, String address, double lng, double lat) {
        this.id = id;
        this.registrationNumber = registrationNumber;
        this.name = name;
        this.activity = activity;
        this.address = address;
        this.lng = lng;
        this.lat = lat;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public int getRegistrationNumber() {
        return registrationNumber;
    }

    public void setRegistrationNumber(int registrationNumber) {
        this.registrationNumber = registrationNumber;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getActivity() {
        return activity;
    }

    public void setActivity(String activity) {
        this.activity = activity;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public double getLng() {
        return lng;
    }

    public void setLng(double lng) {
        this.lng = lng;
    }

    public double getLat() {
        return lat;
    }

    public void setLat(double lat) {
        this.lat = lat;
    }
}
