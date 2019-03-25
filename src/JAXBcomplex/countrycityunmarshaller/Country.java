package JAXBcomplex.countrycityunmarshaller;


import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import java.util.ArrayList;
import java.util.List;

@XmlType(propOrder = { "name", "climate", "capital", "cities" }, name = "countries")
public class Country {

     String name;
     String capital;
     Climate climate;
    List<City> cities = new ArrayList<City>();

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCapital() {
        return capital;
    }

    public void setCapital(String capital) {
        this.capital = capital;
    }

    public Climate getClimate() {
        return climate;
    }

    public void setClimate(Climate climate) {
        this.climate = climate;
    }

    @XmlElementWrapper(name = "cities")
    @XmlElement(name = "city")
    public void setCities(List<City> cities) {
        this.cities = cities;
    }

    public List<City> getCities() {
        return cities;
    }

    @Override
    public String toString() {
        return "Country { " +
                "name=" + name + "\n" +
                " capital=" + capital + "\n" +
                " climate=" + climate + "\n" +
                " cities=" + cities.toString() + "\n" +
                '}';
    }
}
