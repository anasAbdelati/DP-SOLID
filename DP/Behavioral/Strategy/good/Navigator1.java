public class Navigator1 {
    private RouteStrategy routeStrategy;

    // Dependency Injection: Set the strategy at runtime
    public void setRouteStrategy(RouteStrategy routeStrategy) {
        this.routeStrategy = routeStrategy;
    }

    public void build(String start, String end) {
        if (routeStrategy == null) {
            System.out.println("Error: No transport mode selected.");
            return;
        }
        // The Navigator doesn't know HOW the route is built. 
        // It just tells the strategy to do its job.
        routeStrategy.buildRoute(start, end);
    }
}