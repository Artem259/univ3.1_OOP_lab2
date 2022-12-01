package plane.collection;

import org.junit.Before;
import org.junit.Test;
import plane.Plane;
import plane.collection.parser.DomXmlParser;
import plane.collection.parser.SaxXmlParser;
import plane.collection.parser.StaxXmlParser;

import static org.junit.Assert.assertEquals;
import static plane.PlaneTypes.*;

public class CollectionTest {
    private Collection collection;
    private static final String xmlFilePath = "src/main/files/xml_file.xml";
    private static final String xsdFilePath = "src/main/files/xsd_file.xsd";

    @Before
    public void setUp() {
        collection = new Collection();
        Plane plane;

        plane = new Plane();
        plane.setModel("model_1");
        plane.setOrigin("country_1");
        plane.setType(SUPPORT);
        plane.setSeats(2);
        plane.setMissiles(4);
        plane.setHasRadar(true);
        plane.setLength(14.4);
        plane.setWidth(7);
        plane.setHeight(2.8);
        plane.setPrice(14750);
        collection.addPlane(plane);

        plane = new Plane();
        plane.setModel("model_2");
        plane.setOrigin("country_2");
        plane.setType(SCOUT);
        plane.setSeats(2);
        plane.setHasRadar(true);
        plane.setLength(25);
        plane.setWidth(12.4);
        plane.setHeight(4.8);
        plane.setPrice(38950.75);
        collection.addPlane(plane);

        plane = new Plane();
        plane.setModel("model_3");
        plane.setOrigin("country_3");
        plane.setType(FIGHTER);
        plane.setSeats(1);
        plane.setMissiles(8);
        plane.setHasRadar(false);
        plane.setLength(12);
        plane.setWidth(6.8);
        plane.setHeight(3.2);
        plane.setPrice(17250);
        collection.addPlane(plane);
    }

    @Test
    public void fromXmlFile() {
        Collection testCollection = new Collection();
        int resCode;

        resCode = testCollection.fromXmlFile(xmlFilePath, xsdFilePath, new SaxXmlParser());
        assertEquals(0, resCode);
        assertEquals(collection, testCollection);

        resCode = testCollection.fromXmlFile(xmlFilePath, xsdFilePath, new DomXmlParser());
        assertEquals(0, resCode);
        assertEquals(collection, testCollection);

        resCode = testCollection.fromXmlFile(xmlFilePath, xsdFilePath, new StaxXmlParser());
        assertEquals(0, resCode);
        assertEquals(collection, testCollection);
    }
}
