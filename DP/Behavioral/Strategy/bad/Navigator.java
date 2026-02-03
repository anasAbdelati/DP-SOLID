/**
 * VIOLATION: 
 * 1. High Coupling: Navigator knows the internal details of every transport mode.
 * 2. OCP Violation: To add "Public Transport", we must modify this class.
 * 3. Low Maintainability: The method will eventually become a 500-line "spaghetti" method.
 */
public class Navigator {
    public void buildRoute(String start, String end, String mode) {
        if (mode.equalsIgnoreCase("DRIVING")) {
            // Complex driving logic...
            System.out.println("Route: Take Highway 101 from " + start + " to " + end);
        } else if (mode.equalsIgnoreCase("WALKING")) {
            // Complex walking logic...
            System.out.println("Route: Use the pedestrian bridge from " + start + " to " + end);
        } else if (mode.equalsIgnoreCase("CYCLING")) {
            // Complex cycling logic...
            System.out.println("Route: Follow the green bike lane from " + start + " to " + end);
        } else {
            throw new IllegalArgumentException("Unknown transport mode");
        }
    }
}