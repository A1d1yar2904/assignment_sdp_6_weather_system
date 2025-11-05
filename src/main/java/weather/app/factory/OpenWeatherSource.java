package weather.app.factory;

import org.springframework.stereotype.Component;
import weather.app.model.WeatherData;

@Component
public class OpenWeatherSource implements WeatherSource {

    @Override public String name() { return "open"; }

    @Override
    public WeatherData read(String city) {
        String c = city == null ? "Almaty" : city;
        return forCity(c, "open-rt");
    }

    @Override
    public WeatherData readManual(String city) {
        String c = city == null ? "Almaty" : city;
        WeatherData d = forCity(c, "open-manual");
        d.setTemperature(d.getTemperature() + 0.9);
        d.setPressure(d.getPressure() - 2);
        return d;
    }

    private WeatherData forCity(String city, String sourceTag) {
        String key = city.trim().toLowerCase();
        return switch (key) {
            case "astana" -> new WeatherData("Astana", -1.2, "clouds", 72, 1016, 18, sourceTag);
            case "almaty" -> new WeatherData("Almaty", 7.3, "sunny", 35, 1011, 8, sourceTag);
            case "shymkent" -> new WeatherData("Shymkent", 9.1, "sunny", 42, 1009, 14, sourceTag);
            case "atyrau" -> new WeatherData("Atyrau", 2.4, "mist", 68, 1005, 24, sourceTag);
            case "karaganda" -> new WeatherData("Karaganda", -3.5, "snow", 85, 1020, 17, sourceTag);
            default -> new WeatherData("Almaty", 7.3, "sunny", 35, 1011, 8, sourceTag);
        };
    }
}