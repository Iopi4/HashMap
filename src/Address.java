import java.util.Objects;

public class Address {
    protected String country;
    protected String city;

    public Address(String country, String city) {
        this.country = country;
        this.city = city;
    }

    public String getCountry() {
        return country;
    }

    public String getCity() {
        return city;
    }

    //Далее необходимо переопределить equals и hashCode, что бы он возвращал одинаковые значения для одинаковых объектов
    // и разные значения для разных объектов.

    @Override
    public int hashCode() {
        return Objects.hash(country, city);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null || getClass() != obj.getClass()) return false;
        Address address = (Address) obj;
        return country.equals(address.country) && city.equals(address.city);
    }
}