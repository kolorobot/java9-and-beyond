package pl.codeleak.samples.java14.records;

public record Owner(String name, String address, String city, String telephone) {
    /* Records may have static methods */
    public static Owner anOwner(String name) {
        return new Owner(name, null, null, null);
    }
}
