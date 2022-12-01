package plane.collection;

import plane.Plane;
import plane.collection.parser.XmlParser;

import java.util.ArrayList;
import java.util.List;

public class Collection {
    private List<Plane> planes;

    public Collection() {
        planes = new ArrayList<>();
    }

    public void clear() {
        planes.clear();
    }

    public void addPlane(Plane plane) {
        planes.add(plane);
    }

    public Plane getPlane(int index) {
        return planes.get(index);
    }

    public void removePlane(int index) {
        planes.remove(index);
    }

    public int fromXmlFile(String xmlFilePath, String xsdFilePath, XmlParser parser) {
        List<Plane> list = new ArrayList<>();
        planes = parser.parseFromXml(xmlFilePath, xsdFilePath);
        return parser.getResultCode();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (int i=0; i<planes.size(); i++) {
            Plane plane = planes.get(i);
            sb.append(i).append(" # ").append(plane.toString()).append("\n");
        }
        return sb.toString();
    }
}
