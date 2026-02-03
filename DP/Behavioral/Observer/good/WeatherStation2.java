import java.util.ArrayList;
import java.util.List;

public class WeatherStation2 implements Subject {
    private final List<Observer> observers = new ArrayList<>();
    private float temperature;

    @Override
    public void registerObserver(Observer o) {
        observers.add(o);
    }

    @Override
    public void removeObserver(Observer o) {
        observers.remove(o);
    }

    @Override
    public void notifyObservers() {
        for (Observer observer : observers) {
            observer.update(temperature);
        }
    }

    public void setTemperature(float temp) {
        this.temperature = temp;
        notifyObservers(); // Automatically push updates to everyone
    }
}