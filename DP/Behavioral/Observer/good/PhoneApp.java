public class PhoneApp implements Observer {
    @Override
    public void update(float temperature) {
        System.out.println("Phone App: New weather data received: " + temperature);
    }
}