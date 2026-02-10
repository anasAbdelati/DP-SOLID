/**
 * VIOLATION:
 * The RemoteControl is tightly coupled to specific device classes (Light, Stereo).
 * Adding a new device requires modifying this class (violating OCP).
 */
class Light {
    public void on() { System.out.println("Light is ON"); }
    public void off() { System.out.println("Light is OFF"); }
}

public class RemoteControlBad {
    private Light light; // Hard-coded dependency

    public RemoteControlBad(Light light) {
        this.light = light;
    }

    public void pressButton() {
        // Hard-coded behavior: What if we want to control a Stereo?
        light.on();
    }
}