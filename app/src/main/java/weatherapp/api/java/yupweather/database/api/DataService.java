package weatherapp.api.java.yupweather.database.api;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;
import weatherapp.api.java.yupweather.model.WeatherDay;

//https://api.openweathermap.org/data/2.5/weather?lat=44.34&lon=10.99&appid=b67f25d3dbc12d7d9ed5c12b09e1bafd


public interface DataService {

    @GET("weather")
    Call <WeatherDay> getDayWeather (
            @Query("lat") String latitude,
            @Query("lon") String longitude,
            @Query("appid") String apiKey
    );
}
