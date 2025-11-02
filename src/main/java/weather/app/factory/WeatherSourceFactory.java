package weather.app.factory;

import org.springframework.stereotype.Component;

@Component
public class WeatherSourceFactory {
    private final LocalWeatherSource local = new LocalWeatherSource();
    private final OpenWeatherSource open = new OpenWeatherSource();

    public WeatherSource build(String source) {
        if ("open".equalsIgnoreCase(source)) return open;
        return local;
    }
}