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
    private int id;

    @SerializedName("main")
    private final String getMainDay;
    @SerializedName("description")
    private final String descriptionDAy;
    @SerializedName("icon")
    private final String iconWeather;
    @SerializedName("temp")
    private final String tempDay;
    @SerializedName("feels_like")
    private final String mainDay;
    @SerializedName("temp_min")
    private final String tempMinDay;
    @SerializedName("temp_max")
    private final String tempMaxDay;
    @SerializedName("pressure")
    private final String pressureDay;
    @SerializedName("humidity")
    private final String humidityDay;
    @SerializedName("speed")
    private final String windSpeedDay;
    @SerializedName("country")
    private final String countryName;
    @SerializedName("name")
    private final String cityName;

    public WeatherDay(
            int id,
            String getMainDay,
            String descriptionDAy,
            String iconWeather,
            String tempDay,
            String mainDay,
            String tempMinDay,
            String tempMaxDay,
            String pressureDay,
            String humidityDay,
            String windSpeedDay,
            String countryName,
            String cityName
    ) {
        this.id = id;
        this.getMainDay = getMainDay;
        this.descriptionDAy = descriptionDAy;
        this.iconWeather = iconWeather;
        this.tempDay = tempDay;
        this.mainDay = mainDay;
        this.tempMinDay = tempMinDay;
        this.tempMaxDay = tempMaxDay;
        this.pressureDay = pressureDay;
        this.humidityDay = humidityDay;
        this.windSpeedDay = windSpeedDay;
        this.countryName = countryName;
        this.cityName = cityName;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getGetMainDay() {
        return getMainDay;
    }

    public String getDescriptionDAy() {
        return descriptionDAy;
    }

    public String getIconWeather() {
        return iconWeather;
    }

    public String getMainDay() {
        return mainDay;
    }

    public String getPressureDay() {
        return pressureDay;
    }

    public String getHumidityDay() {
        return humidityDay;
    }

    public String getCountryName() {
        return countryName;
    }

    public String getCityName() {
        return cityName;
    }
}
