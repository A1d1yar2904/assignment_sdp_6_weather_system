package weather.app.factory;

import org.springframework.stereotype.Component;
import weather.app.model.WeatherData;

@Component
public class OpenWeatherSource implements WeatherSource {
    @Override public String name() { return "open"; }

    @Override
    public WeatherData read() {
        return new WeatherData(25.0, 50, 1010, name());
    }
}