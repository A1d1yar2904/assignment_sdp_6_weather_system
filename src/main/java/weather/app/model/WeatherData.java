package weather.app.model;

public class WeatherData {
    private final double temperature;
    private final int humidity;
    private final int pressure;
    private final String source;

    public WeatherData(double temperature, int humidity, int pressure, String source) {
        this.temperature = temperature;
        this.humidity = humidity;
        this.pressure = pressure;
        this.source = source;
    }

    public double getTemperature() { return temperature; }
    public int getHumidity() { return humidity; }
    public int getPressure() { return pressure; }
    public String getSource() { return source; }
}