package JAXBcomplex;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlType(propOrder = { "name", "members" }, name = "group")
@XmlRootElement
public class Group {
    private String name;
    private List<Person> members = new ArrayList<Person>();

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @XmlElementWrapper(name = "members")
    @XmlElement(name = "person")
    public List<Person> getMembers() {
        return members;
    }

    public void setMembers(List<Person> members) {
        this.members = members;
    }
}