public class Theropods extends Carnivore {
    private double weight;

    public Theropods(String name, double height, String period, String whereFound, double weight) {
        super(name, height, period, whereFound);
        this.weight = weight;
    }
}
