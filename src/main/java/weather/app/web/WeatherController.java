package weather.app.web;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import weather.app.facade.WeatherFacade;
import weather.app.model.WeatherData;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class WeatherController {

    private final WeatherFacade weatherFacade;

    @GetMapping("/ping")
    public String ping() { return "OK"; }

    @GetMapping("/current")
    public WeatherData getCurrent(@RequestParam String source,
                                  @RequestParam String mode,
                                  @RequestParam(required = false) String city) {
        return weatherFacade.current(source, mode, city);
    }
}