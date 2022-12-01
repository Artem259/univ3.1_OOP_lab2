package plane.collection.parser;

import org.xml.sax.Attributes;
import org.xml.sax.helpers.DefaultHandler;
import plane.Plane;
import plane.PlaneTypes;

import java.util.ArrayList;
import java.util.List;

public class SaxHandler extends DefaultHandler {
    private final List<Plane> planeList;
    private Plane plane;
    private String element;
    private StringBuilder elementData;

    public SaxHandler() {
        this.planeList = new ArrayList<>();
        this.plane = null;
        this.element = null;
        this.elementData = null;
    }

    public List<Plane> getPlaneList() {
        return planeList;
    }

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) {
        element = qName;
        elementData = new StringBuilder();
        if (element.equalsIgnoreCase("plane")) {
            plane = new Plane();
        }
    }

    @Override
    public void endElement(String uri, String localName, String qName) {
        String strData = elementData.toString();

        if (element.equalsIgnoreCase("model")) {
            plane.setModel(strData);
        } else if (element.equalsIgnoreCase("origin")) {
            plane.setOrigin(strData);
        } else if (element.equalsIgnoreCase("type")) {
            plane.setType(PlaneTypes.valueOf(strData));
        } else if (element.equalsIgnoreCase("seats")) {
            plane.setSeats(Integer.parseInt(strData));
        } else if (element.equalsIgnoreCase("missiles")) {
            plane.setMissiles(Integer.parseInt(strData));
        } else if (element.equalsIgnoreCase("radar")) {
            plane.setHasRadar(Boolean.parseBoolean(strData));
        } else if (element.equalsIgnoreCase("length")) {
            plane.setLength(Double.parseDouble(strData));
        } else if (element.equalsIgnoreCase("width")) {
            plane.setWidth(Double.parseDouble(strData));
        } else if (element.equalsIgnoreCase("height")) {
            plane.setHeight(Double.parseDouble(strData));
        } else if (element.equalsIgnoreCase("price")) {
            plane.setPrice(Double.parseDouble(strData));
        }

        if (qName.equalsIgnoreCase("plane")) {
            planeList.add(plane);
        }
    }

    @Override
    public void characters(char[] ch, int start, int length) {
        String str = new String(ch,start,length);
        if (!str.contains("\n")) {
            elementData.append(str);
        }
    }
}
