class SamsungFactory implements EcosystemFactory {
    public Phone createPhone() {
        return new SamsungPhone();
    }

    public Watch createWatch() {
        return new SamsungWatch();
    }
}
