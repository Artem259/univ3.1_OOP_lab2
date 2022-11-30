package plane;

public class Plane {
    private int id;
    private String model;
    private String origin;

    private PlaneTypes type;
    private int seats;
    private boolean hasAmmunition;
    private int missiles;
    private boolean hasRadar;

    private double[] parameters;
    private double price;

    public Plane(PlaneTypes type) {
        if(type == PlaneTypes.SCOUT) {
            setTypeScout(1, false);
        } else {
            setTypeNotScout(type, 1, 1, false);
        }
        setId(0);
        setModel("");
        setOrigin("");
        setParameters(new double[]{0, 0, 0});
        setPrice(0);
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public void setOrigin(String origin) {
        this.origin = origin;
    }

    public void setTypeScout(int seats, boolean hasRadar) {
        this.type = PlaneTypes.SCOUT;
        setSeats(seats);
        this.hasAmmunition = false;
        setHasRadar(hasRadar);
    }

    public void setTypeNotScout(PlaneTypes type, int seats, int missiles, boolean hasRadar) {
        if (type == PlaneTypes.SCOUT) {
            throw new IllegalArgumentException();
        }
        this.type = type;
        setSeats(seats);
        this.hasAmmunition = true;
        setMissiles(missiles);
        setHasRadar(hasRadar);
    }

    public void setSeats(int seats) {
        if (seats < 1 || seats > 2) {
            throw new IllegalArgumentException();
        }
        this.seats = seats;
    }

    public void setMissiles(int missiles) {
        if (!hasAmmunition) {
            throw new IllegalArgumentException("!hasAmmunition");
        }
        if (missiles < 0 || missiles > 10) {
            throw new IllegalArgumentException("missiles < 0 || missiles > 10");
        }
        this.missiles = missiles;
    }

    public void setHasRadar(boolean hasRadar) {
        this.hasRadar = hasRadar;
    }

    public void setParameters(double[] parameters) {
        if (parameters.length != 3) {
            throw new IllegalArgumentException("parameters.length != 3");
        }
        this.parameters = parameters;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getId() {
        return id;
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

    public boolean isHasAmmunition() {
        return hasAmmunition;
    }

    public int getMissiles() {
        return missiles;
    }

    public boolean isHasRadar() {
        return hasRadar;
    }

    public double[] getParameters() {
        return parameters;
    }

    public double getPrice() {
        return price;
    }
}
