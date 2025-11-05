package weather.app.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class WeatherData {
    private String city;
    private double temperature;
    private String condition;
    private Integer humidity;
    private Integer pressure;
    private Integer wind;
    private String source;

    public static WeatherData sample(String city, String sourceTag) {
        return new WeatherData(city, 22.5, "clear", 45, 1013, 12, sourceTag);
    }
}