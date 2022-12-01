package plane.collection.parser;

import org.w3c.dom.Document;
import plane.Plane;
import plane.collection.parser.validator.XsdValidator;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.sax.SAXResult;
import java.io.File;
import java.util.List;

public class DomXmlParser extends XmlParser {
    @Override
    public List<Plane> parseFromXml(String xmlFilePath, String xsdFilePath) {
        XsdValidator validation = new XsdValidator(xmlFilePath, xsdFilePath);
        if (!validation.validate()) {
            resultCode = 1;
            return null;
        }
        try {
            DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
            DocumentBuilder db = dbf.newDocumentBuilder();
            Document document = db.parse(new File(xmlFilePath));

            SaxHandler handler = new SaxHandler();
            TransformerFactory transformerFactory = TransformerFactory.newInstance();
            Transformer transformer = transformerFactory.newTransformer();
            transformer.transform(new DOMSource(document), new SAXResult(handler));
            resultCode = 0;
            return handler.getPlaneList();
        } catch (Exception e) {
            e.printStackTrace();
            resultCode = 2;
            return null;
        }
    }
}
