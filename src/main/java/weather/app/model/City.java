package weather.app.model;

public enum City {
    ASTANA, ALMATY, KARAGANDA, SHYMKENT, NEW_YORK;

    public static City from(String s) {
        return City.valueOf(s.trim().toUpperCase().replace(' ', '_'));
    }
}