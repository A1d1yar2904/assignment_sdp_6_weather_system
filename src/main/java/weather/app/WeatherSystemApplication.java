package weather.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = "weather.app")
public class WeatherSystemApplication {

    public static void main(String[] args) {
        SpringApplication.run(WeatherSystemApplication.class, args);
        System.out.println("✅ Weather System Application started successfully on http://localhost:8080");
    }
}