package weather.app.strategy;

import org.springframework.stereotype.Component;
import weather.app.factory.WeatherSource;
import weather.app.model.WeatherData;

@Component
public class RealTimeUpdateStrategy implements UpdateStrategy {
    @Override
    public WeatherData fetch(WeatherSource src) {
        return src.read();
    }
}