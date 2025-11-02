package weather.app.observer;

import org.springframework.stereotype.Component;
import weather.app.model.WeatherData;

@Component
public class ConsoleDisplay implements DisplayObserver {
    @Override public String id() { return "console"; }
    @Override public String name() { return "Console Display"; }

    @Override
    public void update(WeatherData data) {
        System.out.println("[Display] " + data.getSource()
                + " | Temp=" + data.getTemperature() + "°C"
                + ", Hum=" + data.getHumidity() + "%"
                + ", Press=" + data.getPressure() + " hPa");
    }
}