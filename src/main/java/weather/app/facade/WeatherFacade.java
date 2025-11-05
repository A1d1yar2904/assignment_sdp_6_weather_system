package weather.app.facade;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import weather.app.factory.WeatherSource;
import weather.app.factory.WeatherSourceFactory;
import weather.app.model.WeatherData;

@Service
@RequiredArgsConstructor
public class WeatherFacade {

    private final WeatherSourceFactory sourceFactory;

    public WeatherData current(String source, String mode, String city) {
        WeatherSource ws = sourceFactory.build(source);
        return "manual".equalsIgnoreCase(mode) ? ws.readManual(city) : ws.read(city);
    }
}