package dom_parser.parsing;

/**
 * Created by Admin on 3/18/2019.
 */
public interface XmlParser<T> {
    T parse(String file) throws Exception;
}
