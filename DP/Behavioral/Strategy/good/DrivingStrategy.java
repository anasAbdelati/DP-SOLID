public class DrivingStrategy implements RouteStrategy {
    @Override
    public void buildRoute(String start, String end) {
        System.out.println("DRIVING: Calculating fastest route via GPS and Traffic data.");
    }
}