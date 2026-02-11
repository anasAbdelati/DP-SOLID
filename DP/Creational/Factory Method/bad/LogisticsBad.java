/**
 * ARCHITECTURAL VIOLATIONS:
 * 1. Hardcoded: The App is welded to the 'Truck' class.
 * 2. Violation of OCP: Adding a 'Ship' requires modifying the existing 'orderTransport' logic.
 * 3. Scalability: Every new transport type leads to a massive, messy if-else chain.
 */
class LogisticsBad {
    public void orderTransport(String type) {
        if (type.equals("ROAD")) {
            TruckBad truck = new TruckBad();
            truck.deliver();
        } else if (type.equals("SEA")) {
            // We have to keep adding 'else if' for every new transport
            ShipBad ship = new ShipBad();
            ship.deliver();
        }
    }
}

class TruckBad { void deliver() { System.out.println("Delivering by road."); } }
class ShipBad { void deliver() { System.out.println("Delivering by sea."); } }