package weather.app.facade;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import weather.app.factory.WeatherSource;
import weather.app.factory.WeatherSourceFactory;
import weather.app.model.WeatherData;
import weather.app.strategy.ManualUpdateStrategy;
import weather.app.strategy.RealTimeUpdateStrategy;

@Service
@RequiredArgsConstructor
public class WeatherFacade {

    private final WeatherSourceFactory sourceFactory;
    private final RealTimeUpdateStrategy realTime;
    private final ManualUpdateStrategy manual;

    public WeatherData current(String source, String mode) {
        WeatherSource ws = sourceFactory.build(source);
        if ("rt".equalsIgnoreCase(mode) || "realtime".equalsIgnoreCase(mode)) {
            return realTime.fetch(ws);
        }
        return manual.fetch(ws);
    }
}