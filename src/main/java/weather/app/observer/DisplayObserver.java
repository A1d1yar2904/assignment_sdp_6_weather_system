package weather.app.observer;

import weather.app.model.WeatherData;

public interface DisplayObserver {
    String id();
    String name();
    void update(WeatherData data);
}