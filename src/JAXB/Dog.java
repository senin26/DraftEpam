package JAXB;

import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlType(name = "dog")
@XmlRootElement
public class Dog {
public String name;
public int age;
public int weight;

    public Dog() {
    }
}

