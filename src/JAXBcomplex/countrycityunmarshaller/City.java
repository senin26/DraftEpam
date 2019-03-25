package JAXBcomplex.countrycityunmarshaller;

import javax.xml.bind.annotation.XmlType;

@XmlType(propOrder = { "name", "population" }, name = "city")
public class City {
    String name;
    int population;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPopulation() {
        return population;
    }

    public void setPopulation(int population) {
        this.population = population;
    }

    @Override
    public String toString() {
        return "\n" +
                "name = " + name + "\n" +
                " population = " + population + "\n";
    }
}
