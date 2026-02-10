public class Profile {
    private final String name;
    private final String platform;

    public Profile(String name, String platform) {
        this.name = name;
        this.platform = platform;
    }

    @Override
    public String toString() {
        return platform + ": " + name;
    }
}