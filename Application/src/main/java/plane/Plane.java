package plane;

import java.util.Objects;

public class Plane {
    private String model;
    private String origin;

    private PlaneTypes type;
    private int seats;
    private Integer missiles;
    private boolean hasRadar;

    private double length;
    private double width;
    private double height;
    private double price;

    public Plane() {
        setModel("");
        setOrigin("");
        setType(PlaneTypes.FIGHTER);
        setSeats(1);
        setHasRadar(false);
        setLength(0);
        setWidth(0);
        setHeight(0);
        setPrice(0);
    }

    public void setModel(String model) {
        this.model = model;
    }

    public void setOrigin(String origin) {
        this.origin = origin;
    }

    public void setType(PlaneTypes type) {
        if (missiles == null && type != PlaneTypes.SCOUT) {
            this.missiles = 0;
        }
        this.type = type;
        if (this.type == PlaneTypes.SCOUT) {
            this.missiles = null;
        }
    }

    public void setSeats(int seats) {
        if (seats < 1 || seats > 2) {
            throw new IllegalArgumentException();
        }
        this.seats = seats;
    }

    public void setMissiles(Integer missiles) {
        if (this.type == PlaneTypes.SCOUT) {
            throw new IllegalArgumentException("this.type == PlaneTypes.SCOUT");
        }
        if (missiles < 0 || missiles > 10) {
            throw new IllegalArgumentException("missiles < 0 || missiles > 10");
        }
        this.missiles = missiles;
    }

    public void setHasRadar(boolean hasRadar) {
        this.hasRadar = hasRadar;
    }

    public void setLength(double length) {
        this.length = length;
    }

    public void setWidth(double width) {
        this.width = width;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getModel() {
        return model;
    }

    public String getOrigin() {
        return origin;
    }

    public PlaneTypes getType() {
        return type;
    }

    public int getSeats() {
        return seats;
    }

    public Integer getMissiles() {
        return missiles;
    }

    public boolean isHasRadar() {
        return hasRadar;
    }

    public double getLength() {
        return length;
    }

    public double getWidth() {
        return width;
    }

    public double getHeight() {
        return height;
    }

    public double getPrice() {
        return price;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Plane plane)) {
            return false;
        }
        return seats == plane.seats && Objects.equals(missiles, plane.missiles) && hasRadar == plane.hasRadar
                && Double.compare(plane.price, price) == 0 && Objects.equals(model, plane.model)
                && Objects.equals(origin, plane.origin) && type == plane.type
                && Double.compare(plane.length, length) == 0 && Double.compare(plane.width, width) == 0
                && Double.compare(plane.height, height) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(model, origin, type, seats, missiles, hasRadar, length, width, height, price);
    }

    @Override
    public String toString() {
        return "Plane: model=\"" + model + "\", origin=\"" + origin + "\", type=\"" + type + "\", seats=\"" + seats
                + "\", missiles=\"" + missiles + "\", hasRadar=\"" + hasRadar + "\", length=\"" + length
                + "\", width=\"" + width + "\", height=\"" + height + "\", price=\"" + price + "\";";
    }
}
