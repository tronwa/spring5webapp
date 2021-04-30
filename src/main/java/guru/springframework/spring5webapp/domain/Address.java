package guru.springframework.spring5webapp.domain;

import com.google.common.base.Objects;

import javax.persistence.Embeddable;

@Embeddable
public class Address {
    private String addressLine;
    private String city;
    private String zip;
    private String state;

    public Address() {
        //jpa demands noarg constructor
    }

    public Address(String addressLine, String city, String zip, String state) {
        this.addressLine = addressLine;
        this.city = city;
        this.zip = zip;
        this.state = state;
    }

    public String getAddressLine() {
        return addressLine;
    }

    public void setAddressLine(String addressLine) {
        this.addressLine = addressLine;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getZip() {
        return zip;
    }

    public void setZip(String zip) {
        this.zip = zip;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Address address = (Address) o;
        return Objects.equal(addressLine, address.addressLine) &&
                Objects.equal(city, address.city) &&
                Objects.equal(zip, address.zip) &&
                Objects.equal(state, address.state);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(addressLine, city, zip, state);
    }

    @Override
    public String toString() {
        return addressLine + ", " + city + " " + state + " " + zip;
    }
}
