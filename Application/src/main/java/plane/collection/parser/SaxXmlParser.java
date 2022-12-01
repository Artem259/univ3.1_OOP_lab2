package plane.collection.parser;

import plane.Plane;
import plane.collection.parser.validation.XsdValidation;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.util.List;

public class SaxXmlParser extends XmlParser {
    @Override
    public List<Plane> parseFromXml(String xmlFilePath, String xsdFilePath) {
        XsdValidation validation = new XsdValidation(xmlFilePath, xsdFilePath);
        if (!validation.validate()) {
            resultCode = 1;
            return null;
        }
        try {
            SAXParserFactory saxParserFactory = SAXParserFactory.newInstance();
            SAXParser saxParser = saxParserFactory.newSAXParser();
            SaxHandler handler = new SaxHandler();
            saxParser.parse(xmlFilePath, handler);
            resultCode = 0;
            return handler.getPlaneList();
        } catch (Exception e) {
            e.printStackTrace();
            resultCode = 2;
            return null;
        }
    }
}
