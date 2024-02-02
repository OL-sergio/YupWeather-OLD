package weatherapp.api.java.yupweather.model;

import com.google.gson.annotations.SerializedName;

public class WeatherDay {
    /*{
        "coord": {
            "lon": 10.99,
             "lat": 44.34
    },
        "weather": [
        {
                "id": 803,
                "main": "Clouds",
                "description": "broken clouds",
                "icon": "04n"
        }
],
        "base": "stations",
            "main": {
                "temp": 277.29,
                "feels_like": 277.29,
                "temp_min": 275.52,
                "temp_max": 279.19,
                "pressure": 1033,
                "humidity": 65,
                "sea_level": 1033,
                "grnd_level": 943
    },
        "visibility": 10000,
            "wind": {
                "speed": 0.17,
                "deg": 198,
                "gust": 0.22
    },
        "clouds": {
        "all": 62
    },
        "dt": 1706719247,
            "sys": {
                "type": 2,
                "id": 2004688,
                "country": "IT",
                "sunrise": 1706682971,
                "sunset": 1706718145
    },
        "timezone": 3600,
            "id": 3163858,
            "name": "Zocca",
            "cod": 200
    }*/
    @SerializedName("id")
    private int getId;
    @SerializedName("main")
    private String getMainDay;
    @SerializedName("description")
    private String descriptionDAy;
    @SerializedName("icon")
    private  String idIcon;
    @SerializedName("temp")
    private  String tempDay;
    @SerializedName("pressure")
    private String pressureDay;
    @SerializedName("visibility")
    private String visibilityDay;
    @SerializedName("humidity")
    private String humidityDay;
    @SerializedName("speed")
    private String windSpeedDay;
    @SerializedName("country")
    private String countryName;
    @SerializedName("name")
    private String cityName;



    public WeatherDay(
            int getId,
            String getMainDay,
            String descriptionDAy,
            String idIcon,
            String tempDay,
            String pressureDay,
            String visibilityDay,
            String humidityDay,
            String windSpeedDay,
            String countryName,
            String cityName
    ) {
        this.getId = getId;
        this.getMainDay = getMainDay;
        this.descriptionDAy = descriptionDAy;
        this.idIcon = idIcon;
        this.tempDay = tempDay;
        this.pressureDay = pressureDay;
        this.visibilityDay = visibilityDay;
        this.humidityDay = humidityDay;
        this.windSpeedDay = windSpeedDay;
        this.countryName = countryName;
        this.cityName = cityName;
    }

    public int getGetId() {
        return getId;
    }

    public void setGetId(int getId) {
        this.getId = getId;
    }

    public String getGetMainDay() {
        return getMainDay;
    }

    public void setGetMainDay(String getMainDay) {
        this.getMainDay = getMainDay;
    }

    public String getDescriptionDAy() {
        return descriptionDAy;
    }

    public void setDescriptionDAy(String descriptionDAy) {
        this.descriptionDAy = descriptionDAy;
    }

    public String getIdIcon() {
        return idIcon;
    }

    public void setIdIcon(String idIcon) {
        this.idIcon = idIcon;
    }

    public String getTempDay() {
        return tempDay;
    }

    public void setTempDay(String tempDay) {
        this.tempDay = tempDay;
    }

    public String getPressureDay() {
        return pressureDay;
    }

    public void setPressureDay(String pressureDay) {
        this.pressureDay = pressureDay;
    }

    public String getVisibilityDay() {
        return visibilityDay;
    }

    public void setVisibilityDay(String visibilityDay) {
        this.visibilityDay = visibilityDay;
    }

    public String getHumidityDay() {
        return humidityDay;
    }

    public void setHumidityDay(String humidityDay) {
        this.humidityDay = humidityDay;
    }

    public String getWindSpeedDay() {
        return windSpeedDay;
    }

    public void setWindSpeedDay(String windSpeedDay) {
        this.windSpeedDay = windSpeedDay;
    }

    public String getCountryName() {
        return countryName;
    }

    public void setCountryName(String countryName) {
        this.countryName = countryName;
    }

    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }
}
