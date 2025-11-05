package weather.app.factory;

import org.springframework.stereotype.Component;
import weather.app.model.WeatherData;

@Component
public class LocalWeatherSource implements WeatherSource {

    @Override public String name() { return "local"; }

    @Override
    public WeatherData read(String city) {
        String c = city == null ? "Astana" : city;
        return forCity(c, "local-rt");
    }

    @Override
    public WeatherData readManual(String city) {
        String c = city == null ? "Astana" : city;
        WeatherData d = forCity(c, "local-manual");
        d.setTemperature(d.getTemperature() - 0.7);
        d.setHumidity(d.getHumidity() + 3);
        return d;
    }

    private WeatherData forCity(String city, String sourceTag) {
        String key = city.trim().toLowerCase();
        return switch (key) {
            case "astana" -> new WeatherData("Astana", -2.0, "snow", 78, 1018, 22, sourceTag);
            case "almaty" -> new WeatherData("Almaty", 6.5, "clear", 40, 1012, 10, sourceTag);
            case "shymkent" -> new WeatherData("Shymkent", 8.0, "clouds", 48, 1010, 12, sourceTag);
            case "atyrau" -> new WeatherData("Atyrau", 1.5, "windy", 60, 1006, 28, sourceTag);
            case "karaganda" -> new WeatherData("Karaganda", -4.0, "snow", 82, 1019, 20, sourceTag);
            default -> new WeatherData("Astana", -2.0, "snow", 78, 1018, 22, sourceTag);
        };
    }
}