package JAXBcomplex.countryNcity;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import java.io.*;
import java.nio.file.Files;
import java.nio.file.OpenOption;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ApplicationCountryCity {

    public Country createJavaObjectExample1() {
        Country country = new Country();
        appendCountryData(country,"Russia","Moscow", Climate.COLD);
        try {
            country.getCities().add(insertCity("Saint-Petersburg", 5000000));
            country.getCities().add(insertCity("Sochi", 365000));
        } catch (ParseException exception) {
            Logger.getLogger(ApplicationCountryCity.class.getName()).
                    log(Level.ALL, "createJavaObjectExample1 threw ParseException", exception);
        }
        return country;
    }

    public void appendCountryData(Country country, String name, String capital, Climate climate) {
        country.setName(name);
        country.setCapital(capital);
        country.setClimate(climate);
    }

    public City insertCity(String name, int population) throws ParseException {
        City city = new City();
        city.setName(name);
        city.setPopulation(population);
        return city;
    }

    public void marshallExample() {
        try {
            JAXBContext context = JAXBContext.newInstance(Country.class);
            Marshaller marshaller = context.createMarshaller();
            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
            marshaller.marshal(createJavaObjectExample1(), System.out);
        } catch (JAXBException exception) {
            Logger.getLogger(ApplicationCountryCity.class.getName()).
                    log(Level.SEVERE, "marshallExample threw JAXBException", exception);
        }
    }

    public void unmarshallExample() {
        try {
            /*FileOutputStream fos;
            try {
                fos = new FileOutputStream(file);
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }*/
            JAXBContext context =
                    JAXBContext.newInstance(Country.class);

            Unmarshaller unmarshaller =
                    context.createUnmarshaller();

            File file = new File("/init_data.xml");

            Object o = unmarshaller.unmarshal(file);

           /* Marshaller marshaller =
                    context.createMarshaller();

            ByteArrayOutputStream baos =
                    new ByteArrayOutputStream();

            marshaller.marshal(file, baos);

            InputStream bais =
                    new ByteArrayInputStream(baos.toByteArray());*/



            //prove the Country is recreated
            Country countryCopy = (Country) o;
            System.out.println("Objects created from XML:");
            System.out.println(countryCopy.getName() + " " + countryCopy.getCapital() + " " + countryCopy.getClimate());
            for (City city : countryCopy.getCities()) {
                System.out.println(city.getName() + " " + city.getPopulation());
            }
        } catch (JAXBException exception) {
            Logger.getLogger(ApplicationCountryCity.class.getName()).
                    log(Level.SEVERE, "marshallExample threw JAXBException", exception);
        }
    }

    public static void main(String[] args) {
        ApplicationCountryCity instance = new ApplicationCountryCity();
       // instance.marshallExample();
       instance.unmarshallExample();
        System.out.println("Done");
    }
}
