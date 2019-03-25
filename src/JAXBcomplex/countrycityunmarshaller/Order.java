package JAXBcomplex.countrycityunmarshaller;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import java.util.ArrayList;
import java.util.List;

@XmlType(propOrder = { "countries"}, name = "order")
@XmlRootElement
public class Order {

    List<Country> countries = new ArrayList<Country>();

    public List<Country> getCountries() {
        return countries;
    }

    @XmlElementWrapper(name = "countries")
    @XmlElement(name = "country")
    public void setCountries(List<Country> countries) {
        this.countries = countries;
    }

    @Override
    public String toString() {
        return "Order{" +
                "countries=" + countries.toString() +
                '}';
    }
}
