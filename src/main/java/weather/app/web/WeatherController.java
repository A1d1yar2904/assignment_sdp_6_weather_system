package weather.app.web;

import org.springframework.web.bind.annotation.*;
import lombok.RequiredArgsConstructor;
import weather.app.facade.WeatherFacade;
import weather.app.model.WeatherData;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class WeatherController {

    private final WeatherFacade weatherFacade;

    @GetMapping({"/api/ping", "/ping"})
    public String ping() {
        return "OK";
    }


    @GetMapping("/weather/{source}/{mode}")
    public WeatherData getWeather(
            @PathVariable String source,
            @PathVariable String mode
    ) {
        try {
            return weatherFacade.current(source.toLowerCase(), mode.toLowerCase());
        } catch (Exception e) {
            return new WeatherData(0.0, 0, 0, "Error: " + e.getMessage());
        }
    }
}