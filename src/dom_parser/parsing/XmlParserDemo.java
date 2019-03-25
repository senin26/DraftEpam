package dom_parser.parsing;


import dom_parser.model.Person;
import dom_parser.utils.FileUtils;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

/**
 * Created by Admin on 3/18/2019.
 */
public class XmlParserDemo {
    public static void main(String[] args) {
        File fileWithXml = null;
        try {
            fileWithXml = FileUtils.createFileFromResource("persons", ".xml", "/parsing/persons.xml");
            List<Person> persons = new DomXmlParser().parse(fileWithXml.getAbsolutePath());
            for (Person person : persons) {
                System.out.println(person + "\n");
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (fileWithXml != null) {
                try {
                    Files.delete(Paths.get(fileWithXml.toURI()));
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
