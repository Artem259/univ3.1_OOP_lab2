package plane.collection.parser;

import plane.Plane;

import java.util.List;

public abstract class XmlParser {
    protected int resultCode;

    public int getResultCode() {
        return resultCode;
    }

    abstract public List<Plane> parseFromXml(String xmlFilePath, String xsdFilePath);
}
