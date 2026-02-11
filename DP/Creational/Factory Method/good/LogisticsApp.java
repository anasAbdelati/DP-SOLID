public class LogisticsApp {
    public static void main(String[] args) {
        Logistics logistics;

        // In a real app, this choice comes from a config file or env variable
        String zone = "INTERNATIONAL";

        if (zone.equals("LOCAL")) {
            logistics = new RoadLogistics();
        } else {
            logistics = new SeaLogistics();
        }

        // High-level logic remains untouched regardless of the transport type
        logistics.planDelivery();
    }
}