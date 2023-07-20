public abstract class Herbivore implements Dinosaur {
    private final String name;
    private final double height;
    private final String period;
    private final String whereFound;

    public Herbivore(String name, double height, String period, String whereFound) {
        this.name = name;
        this.height = height;
        this.period = period;
        this.whereFound = whereFound;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public double getHeight() {
        return height;
    }

    @Override
    public String getPeriod() {
        return period;
    }

    @Override
    public String getWhereFound() {
        return whereFound;
    }

    @Override
    public int compareTo(Dinosaur o) {
        return Double.compare(height, o.getHeight());
    }

    @Override
    public String toString() {
        return name + ".  Height: " + height + "m. Found in " + whereFound + ".  Lived in " + period + "." ;
    }
}
