package renovation.models;

public class Tile {
    public double width;
    public double height;
    public double depth;
    public double area;

    public Tile(double width, double height, double depth) {
        this.width = width;
        this.height = height;
        this.depth = depth;
        this.area = width * height;
    }

    @Override
    public String toString() {
        return "models.Tile{" +
                "width=" + width +
                ", height=" + height +
                ", depth=" + depth +
                '}';
    }
}
