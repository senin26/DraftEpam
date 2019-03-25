package JAXBcomplex.countrycityunmarshaller;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import java.io.*;

public class ApplicationCountryCity {
    public void unmarshallExample() throws JAXBException {
        File file = new File("resources\\init_data2.xml");

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

    }

    public static void main(String[] args) {
        ApplicationCountryCity instance = new ApplicationCountryCity();
        try {
            instance.unmarshallExample();
        } catch (JAXBException e) {
            e.printStackTrace();
        }
    }
}
