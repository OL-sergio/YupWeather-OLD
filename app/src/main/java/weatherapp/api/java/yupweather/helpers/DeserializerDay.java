package weatherapp.api.java.yupweather.helpers;

import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonParseException;

import java.lang.reflect.Type;

import weatherapp.api.java.yupweather.model.WeatherDay;

public class DeserializerDay implements JsonDeserializer<WeatherDay> {
    @Override
    public WeatherDay deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) throws JsonParseException {

        int id = json.getAsJsonObject()
                .get("id")
                .getAsInt();

        String main = json.getAsJsonObject()
                .get("main")
                .getAsString();

        String description = json.getAsJsonObject()
                .get("description")
                .getAsString();

        String icon = json.getAsJsonObject()
                .get("icon")
                .getAsString();

        String temp = json.getAsJsonObject().get("main")
                .getAsJsonObject().get("temp")
                .getAsString();

        String humidity = json.getAsJsonObject().get("main")
                .getAsJsonObject().get("humidity")
                .getAsString();

        String pressure = json.getAsJsonObject().get("main")
                .getAsJsonObject().get("pressure")
                .getAsString();

        String visibility = json.getAsJsonObject()
                .get("visibility")
                .getAsString();


        String windSpeed = json.getAsJsonObject().get("wind")
                .getAsJsonObject().get("speed")
                .getAsString();

        String country = json.getAsJsonObject().get("sys")
                .getAsJsonObject().get("country")
                .getAsString();

        String name = json.getAsJsonObject()
                .get("name")
                .getAsString();

        WeatherDay weatherDay = new WeatherDay(
                id,
                main,
                description,
                icon,
                temp,
                pressure,
                visibility,
                humidity,
                windSpeed,
                country,
                name
        );

        return weatherDay;
    }
}
