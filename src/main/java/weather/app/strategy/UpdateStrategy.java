package weather.app.strategy;

import weather.app.factory.WeatherSource;
import weather.app.model.WeatherData;

public interface UpdateStrategy {
    WeatherData fetch(WeatherSource src);
}