package weather.app.observer;

import org.springframework.stereotype.Component;
import weather.app.model.WeatherData;

import java.util.ArrayList;
import java.util.List;

@Component
public class WeatherStation {
    private final List<DisplayObserver> observers = new ArrayList<>();

    public WeatherStation(List<DisplayObserver> initial) {
        if (initial != null) observers.addAll(initial);
    }

    public void attach(DisplayObserver obs) { observers.add(obs); }
    public void detach(String id) { observers.removeIf(o -> o.id().equals(id)); }

    public void notifyAllDisplays(WeatherData data) {
        for (var o : observers) o.update(data);
    }
}