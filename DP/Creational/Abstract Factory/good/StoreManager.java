public class StoreManager {
    private Phone phone;
    private Watch watch;

    // The Client is completely blind to concrete classes!
    // It only knows it's getting a "compatible family"
    public StoreManager(EcosystemFactory factory) {
        this.phone = factory.createPhone();
        this.watch = factory.createWatch();
    }

    public void startup() {
        phone.call();
        watch.trackSteps();
    }
}