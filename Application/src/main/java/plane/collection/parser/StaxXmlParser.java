package plane.collection.parser;

import plane.Plane;
import plane.collection.parser.validator.XsdValidator;

import javax.xml.stream.XMLEventReader;
import javax.xml.stream.XMLInputFactory;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.sax.SAXResult;
import javax.xml.transform.stax.StAXSource;
import java.io.FileInputStream;
import java.util.List;

public class StaxXmlParser extends XmlParser {
    @Override
    public List<Plane> parseFromXml(String xmlFilePath, String xsdFilePath) {
        XsdValidator validation = new XsdValidator(xmlFilePath, xsdFilePath);
        if (!validation.validate()) {
            resultCode = 1;
            return null;
        }
        try {
            XMLInputFactory xmlInputFactory = XMLInputFactory.newInstance();
            XMLEventReader reader = xmlInputFactory.createXMLEventReader(new FileInputStream(xmlFilePath));

            SaxHandler handler = new SaxHandler();
            TransformerFactory transformerFactory = TransformerFactory.newInstance();
            Transformer transformer = transformerFactory.newTransformer();
            transformer.transform(new StAXSource(reader), new SAXResult(handler));
            resultCode = 0;
            return handler.getPlaneList();
        } catch (Exception e) {
            e.printStackTrace();
            resultCode = 2;
            return null;
        }
    }
}
