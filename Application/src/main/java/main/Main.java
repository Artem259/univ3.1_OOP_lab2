package main;

import plane.collection.Collection;
import plane.collection.parser.DomXmlParser;
import plane.collection.parser.SaxXmlParser;
import plane.collection.parser.StaxXmlParser;
import plane.collection.parser.XmlParser;

public class Main {
    private final String xmlFilePath;
    private final String xsdFilePath;

    public Main(String xmlFilePath, String xsdFilePath) {
        this.xmlFilePath = xmlFilePath;
        this.xsdFilePath = xsdFilePath;
    }

    public void runParsing(XmlParser parser) {
        Collection collection = new Collection();
        if (collection.fromXmlFile(xmlFilePath, xsdFilePath, parser) != 0) {
            throw new RuntimeException();
        }
        System.out.println(collection);
    }

    public void start() {
       runParsing(new SaxXmlParser());
       runParsing(new DomXmlParser());
       runParsing(new StaxXmlParser());
    }

    public static void main(String[] args) {
        String xml = "src/main/files/xml_file.xml";
        String xsd = "src/main/files/xsd_file.xsd";
        new Main(xml, xsd).start();
    }
}
