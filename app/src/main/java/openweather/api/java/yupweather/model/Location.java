package openweather.api.java.yupweather.model;

import java.io.Serializable;

public class Location implements Serializable {

        private String latitudeGps;
        private String longitudeGps;

    public String getLatitudeGps() {
        return latitudeGps;
    }

    public void setLatitudeGps(String latitudeGps) {
        this.latitudeGps = latitudeGps;
    }

    public String getLongitudeGps() {
        return longitudeGps;
    }

    public void setLongitudeGps(String longitudeGps) {
        this.longitudeGps = longitudeGps;
    }
}
