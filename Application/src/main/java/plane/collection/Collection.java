package plane.collection;

import plane.Plane;
import plane.collection.parser.XmlParser;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

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
        List<Plane> list = parser.parseFromXml(xmlFilePath, xsdFilePath);
        if (parser.getResultCode() == 0) {
            planes = list;
        }
        return parser.getResultCode();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Collection that)) {
            return false;
        }
        return Objects.equals(planes, that.planes);
    }

    @Override
    public int hashCode() {
        return Objects.hash(planes);
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
