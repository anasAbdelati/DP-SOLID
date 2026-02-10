class Dimmer {
    public void setBrightness(int level) { System.out.println("Lights dimmed to " + level + "%"); }
}

class Projector {
    public void on() { System.out.println("Projector is warming up..."); }
    public void off() { System.out.println("Projector shutting down..."); }
    public void setInput(String input) { System.out.println("Projector input set to " + input); }
}

class SoundSystem {
    public void on() { System.out.println("Sound system online."); }
    public void off() { System.out.println("Sound system offline."); }
    public void setVolume(int level) { System.out.println("Volume set to " + level); }
}

class StreamingPlayer {
    public void on() { System.out.println("Streaming player active."); }
    public void off() { System.out.println("Streaming player sleeping."); }
    public void play(String movie) { System.out.println("Now playing: " + movie); }
}