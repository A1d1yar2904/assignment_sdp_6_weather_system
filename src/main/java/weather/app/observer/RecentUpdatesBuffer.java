package weather.app.observer;

import org.springframework.stereotype.Component;
import weather.app.model.WeatherData;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.List;

@Component
public class RecentUpdatesBuffer {
    private static final int MAX = 20;
    private final Deque<WeatherData> q = new ArrayDeque<>(MAX);

    public synchronized void add(WeatherData d) {
        if (q.size() == MAX) q.removeFirst();
        q.addLast(d);
    }

    public synchronized List<WeatherData> all() {
        return List.copyOf(q);
    }
}