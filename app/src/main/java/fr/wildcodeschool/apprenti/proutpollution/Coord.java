package fr.wildcodeschool.apprenti.proutpollution;

/**
 * Created by apprenti on 23/01/17.
 */

public class Coord {
    private String lat, lon, strength, date;



    public Coord(){}

    public Coord(String lat, String lon, String strength, String date) {
        this.lat = lat;
        this.lon = lon;
        this.strength = strength;
        this.date = date;
    }

    public String getLat() {
        return lat;
    }

    public void setLat(String lat) {
        this.lat = lat;
    }

    public String getLon() {
        return lon;
    }

    public void setLon(String lon) {
        this.lon = lon;
    }

    public String getStrength() {
        return strength;
    }

    public void setStrength(String strength) {
        this.strength = strength;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
}
