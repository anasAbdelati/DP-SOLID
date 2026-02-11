public class PhoneStoreApp {
    public static void main(String[] args) {
        // In a real enterprise app, 'brand' would come from 
        // a configuration file, environment variable, or database.
        String brand = "SAMSUNG"; 
        EcosystemFactory factory;

        if (brand.equalsIgnoreCase("APPLE")) {
            factory = new AppleFactory();
        } else {
            factory = new SamsungFactory();
        }

        // The StoreManager (Client) doesn't know IF it's Apple or Samsung.
        // It just knows it's getting a compatible Ecosystem.
        StoreManager manager = new StoreManager(factory);
        
        System.out.println("--- Starting up Ecosystem ---");
        manager.startup();
    }
}