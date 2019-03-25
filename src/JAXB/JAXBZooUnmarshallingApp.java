package JAXB;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import java.io.StringReader;
import java.io.StringWriter;

public class JAXBZooUnmarshallingApp {
    public static void main(String[] args) throws JAXBException
    {

            String xmldata = "<zoo>\n" +
                    "    <wild-animals>\n" +
                    "        <animals xsi:type=\"cat\" xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\">\n" +
                    "            <name>Murka</name>\n" +
                    "            <age>5</age>\n" +
                    "            <weight>4</weight>\n" +
                    "        </animals>\n" +
                    "        <animals xsi:type=\"cat\" xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\">\n" +
                    "            <name>Barsik</name>\n" +
                    "            <age>7</age>\n" +
                    "            <weight>5</weight>\n" +
                    "        </animals>\n" +
                    "    </wild-animals>\n" +
                    "</zoo>";
            StringReader reader = new StringReader(xmldata);

            JAXBContext context = JAXBContext.newInstance(Zoo.class, Cat2.class);
            Unmarshaller unmarshaller = context.createUnmarshaller();

            Zoo zoo = (Zoo) unmarshaller.unmarshal(reader);

        System.out.println(zoo.animals.toString());
    }
}
