class AppleFactory implements EcosystemFactory {
    public Phone createPhone() { return new IPhone(); }
    public Watch createWatch() { return new AppleWatch(); }
}

