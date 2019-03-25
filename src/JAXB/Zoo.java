package JAXB;

import javax.xml.bind.annotation.*;
import java.util.ArrayList;
import java.util.List;

@XmlType(name = "zoo")
@XmlRootElement
class Zoo
{
    @XmlElementWrapper(name="wild-animals", nillable = true)
    public List animals = new ArrayList<>();
}

@XmlType(name = "tiger")
class Cat2
{
    @XmlElement(name = "catname")
    public String name;
    @XmlAttribute(name = "age")
    public int age;
    @XmlAttribute(name = "w")
    public int weight;

    public Cat2()
    {
    }
}