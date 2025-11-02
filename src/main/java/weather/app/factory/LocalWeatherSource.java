package weather.app.factory;

import org.springframework.stereotype.Component;
import weather.app.model.WeatherData;

@Component
public class LocalWeatherSource implements WeatherSource {
    @Override public String name() { return "local"; }

    @Override
    public WeatherData read() {
        return new WeatherData(23.5, 55, 1012, name());
    }
}