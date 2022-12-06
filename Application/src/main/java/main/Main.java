package main;

import plane.collection.Collection;
import plane.collection.parser.DomXmlParser;
import plane.collection.parser.SaxXmlParser;
import plane.collection.parser.StaxXmlParser;
import plane.collection.parser.XmlParser;

import java.io.IOException;

public class Main {
    private final String xmlFilePath;
    private final String xsdFilePath;

    public Main(String xmlFilePath, String xsdFilePath) {
        this.xmlFilePath = xmlFilePath;
        this.xsdFilePath = xsdFilePath;
    }

    public void runParsing(XmlParser parser) throws IOException {
        Collection collection = new Collection();
        collection.fromXmlFile(xmlFilePath, xsdFilePath, parser);
        System.out.println(collection);
    }

    public void start() throws IOException {
       runParsing(new SaxXmlParser());
       runParsing(new DomXmlParser());
       runParsing(new StaxXmlParser());
    }

    public static void main(String[] args) throws IOException {
        String xml = "src/main/files/xml_file.xml";
        String xsd = "src/main/files/xsd_file.xsd";
        new Main(xml, xsd).start();
    }
}
