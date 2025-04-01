public class Address {
    private String pref;
    private String city;
    private String town;

    public Address(String pref, String city, String town) {
        this.pref = pref;
        this.city = city;
        this.town = town;
    }

    public String getPref() {
        return pref;
    }

    public String getCity() {
        return city;
    }

    public String getTown() {
        return town;
    }

    public String toString() {
        return pref + " " + city + " " + town;
    }
}
