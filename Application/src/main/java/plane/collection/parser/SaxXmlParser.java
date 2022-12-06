package plane.collection.parser;

import org.xml.sax.SAXException;
import plane.Plane;
import plane.collection.parser.validator.XsdValidator;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.IOException;
import java.util.List;

public class SaxXmlParser extends XmlParser {
    @Override
    public List<Plane> parseFromXml(String xmlFilePath, String xsdFilePath) throws IOException {
        XsdValidator validation = new XsdValidator(xmlFilePath, xsdFilePath);
        if (!validation.validate()) {
            throw new RuntimeException("XSD-validation failed.");
        }
        try {
            SAXParserFactory saxParserFactory = SAXParserFactory.newInstance();
            SAXParser saxParser = saxParserFactory.newSAXParser();
            SaxHandler handler = new SaxHandler();
            saxParser.parse(xmlFilePath, handler);
            return handler.getPlaneList();
        } catch (ParserConfigurationException | SAXException e) {
            throw new RuntimeException("XML parsing failed.");
        }
    }
}
