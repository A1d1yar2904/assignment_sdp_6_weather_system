package weather.app.strategy;

import org.springframework.stereotype.Service;
import weather.app.factory.WeatherSource;
import weather.app.model.WeatherData;

@Service
public class RealTimeUpdateStrategy implements UpdateStrategy {
    public WeatherData fetch(WeatherSource src, String city) {
        return src.read(city);
    }
}