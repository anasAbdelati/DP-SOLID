class Truck implements Transport {
    @Override
    public void deliver() { System.out.println("TRUCK: Delivering cargo via land in a container."); }
}

class Ship implements Transport {
    @Override
    public void deliver() { System.out.println("SHIP: Delivering cargo via sea across the ocean."); }
}