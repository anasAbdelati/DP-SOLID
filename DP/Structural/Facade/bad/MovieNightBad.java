/**
 * ARCHITECTURAL VIOLATIONS:
 * 1. Complexity Exposure: The client has to know about every single hardware class.
 * 2. Missing Logic: If the client forgets 'setVolume', the experience is ruined.
 * 3. High Coupling: If we upgrade to a '4KProjector' with different methods, the client breaks.
 */
class MovieNightBad {
    public void startMovie() {
        // The client is drowning in subsystems
        Dimmer lights = new Dimmer();
        Projector projector = new Projector();
        SoundSystem sound = new SoundSystem();
        StreamingPlayer player = new StreamingPlayer();

        lights.setBrightness(10);
        projector.on();
        projector.setInput("HDMI 1");
        sound.on();
        sound.setVolume(50);
        player.on();
        player.play("Inception");
        
        System.out.println("Movie is starting... hopefully.");
    }
}