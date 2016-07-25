package com.prokkypew.sample.api;

/**
 * Created by alexander_roman on 25.07.16.
 */
public class IpObject {
    public float lat;
    public float lon;
    public String city;
    public String query;

    public String getText() {
        return query + " " + city + " at " + lat + " " + lon;
    }
}
