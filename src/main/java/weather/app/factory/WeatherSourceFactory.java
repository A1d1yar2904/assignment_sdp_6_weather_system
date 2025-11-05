package weather.app.factory;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class WeatherSourceFactory {

    private final LocalWeatherSource local;
    private final OpenWeatherSource open;

    public WeatherSource build(String source) {
        if (source == null) throw new IllegalArgumentException("source is null");
        return switch (source.toLowerCase()) {
            case "local" -> local;
            case "open"  -> open;
            default -> throw new IllegalArgumentException("Unknown source: " + source);
        };
    }
}