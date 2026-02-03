// We added this feature without touching the Navigator! (OCP)
public class PublicTransportStrategy implements RouteStrategy {
    @Override
    public void buildRoute(String start, String end) {
        System.out.println("BUS/TRAIN: Checking schedules and station proximity.");
    }
}