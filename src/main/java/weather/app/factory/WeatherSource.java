package weather.app.factory;

import weather.app.model.WeatherData;

public interface WeatherSource {
    String name();
    WeatherData read();
}