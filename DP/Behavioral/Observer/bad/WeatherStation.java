/**
 * VIOLATION:
 * 1. Hard-coded dependencies: WeatherStation is stuck with PhoneDisplay and WindowDisplay.
 * 2. OCP Violation: Adding a "WebDisplay" requires modifying the WeatherStation class.
 */
class PhoneDisplay {
    public void update(float temp) {
        System.out.println("Phone Display: Temp updated to " + temp);
    }
}

class WindowDisplay {
    public void update(float temp) {
        System.out.println("Window Display: Temp updated to " + temp);
    }
}

public class WeatherStation {
    private float temperature;
    private PhoneDisplay phoneDisplay = new PhoneDisplay();
    private WindowDisplay windowDisplay = new WindowDisplay();

    public void setTemperature(float temp) {
        this.temperature = temp;
        // The Subject has to manually notify every specific class
        phoneDisplay.update(temp);
        windowDisplay.update(temp);
    }
}