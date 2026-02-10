public class SmartHomeFacade {
    private Dimmer lights;
    private Projector projector;
    private SoundSystem sound;
    private StreamingPlayer player;

    public SmartHomeFacade() {
        this.lights = new Dimmer();
        this.projector = new Projector();
        this.sound = new SoundSystem();
        this.player = new StreamingPlayer();
    }

    public void watchMovie(String movieTitle) {
        System.out.println("Facade: Preparing the theater...");
        lights.setBrightness(10);
        projector.on();
        projector.setInput("HDMI 1");
        sound.on();
        sound.setVolume(50);
        player.on();
        player.play(movieTitle);
        System.out.println("Facade: Enjoy your movie!");
    }

    public void endMovie() {
        System.out.println("Facade: Shutting down...");
        lights.setBrightness(100);
        projector.off();
        sound.off();
        player.off();
    }
}