package weatherapp.api.java.yupweather.database.api;

import com.google.gson.GsonBuilder;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import weatherapp.api.java.yupweather.helpers.DeserializerDay;
import weatherapp.api.java.yupweather.model.WeatherDay;
import weatherapp.api.java.yupweather.utilities.Constants;

public class APIClient {

    private static Retrofit retrofit = null;

    public static Retrofit getInstance(){
        if ( retrofit == null ) {

            GsonBuilder builder = new GsonBuilder();
            builder.registerTypeAdapter( WeatherDay.class, new DeserializerDay() );

            retrofit = new Retrofit.Builder()
                    .baseUrl(Constants.BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create(builder.create()))
                    .build();

        }
        return retrofit;
    }
}
