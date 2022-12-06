package plane.collection.parser;

import plane.Plane;

import java.io.IOException;
import java.util.List;

public abstract class XmlParser {
    abstract public List<Plane> parseFromXml(String xmlFilePath, String xsdFilePath) throws IOException;
}
