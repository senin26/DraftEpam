package JAXBcomplex.countrycityunmarshaller;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import java.io.*;
import java.text.ParseException;
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

    public void unmarshallExample() throws JAXBException{
        File file = new File("E:\\Serj\\EPAM\\Drafts\\resources\\init_data2.xml");
        //File file = new File("E:\\Serj\\EPAM\\Drafts\\resources\\init_data.xml");
        //File file = new File("/init_data.xml");
        BufferedInputStream bis = null;
        StringBuilder xml = new StringBuilder();
        int next;
        try {
            bis = new BufferedInputStream(new FileInputStream(file));
            while ((next = bis.read()) != -1) {
                xml.append((char) next);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        String xmldata = xml.toString();
        StringReader reader = new StringReader(xmldata);

        JAXBContext context = JAXBContext.newInstance(Order.class);
        Unmarshaller unmarshaller = context.createUnmarshaller();

        Order order = (Order) unmarshaller.unmarshal(reader);
        System.out.println(order.toString());

        /*Country country = (Country) unmarshaller.unmarshal(reader);
        System.out.println(country.toString());*/
    }

    public static void main(String[] args) {
        ApplicationCountryCity instance = new ApplicationCountryCity();
       //instance.marshallExample();
        try {
            instance.unmarshallExample();
        } catch (JAXBException e) {
            e.printStackTrace();
        }
        System.out.println("\nDone");
    }
}
