package renovation.core;

import renovation.models.Laminate;
import renovation.models.Tile;
import renovation.models.WoodType;

import java.util.*;
import java.util.stream.Collectors;

public class RenovationImpl implements Renovation {

    Deque<Tile> tileStack = new ArrayDeque<>();
    Set<Tile> deliveredTile = new HashSet<>();
    Deque<Laminate> laminateStack = new ArrayDeque<>();
    Set<Laminate> deliveredLaminate = new HashSet<>();
    Set<Tile> sorted = new TreeSet<>(new Comparator<Tile>() {
        @Override
        public int compare(Tile t1, Tile t2) {

            int compared = Double.compare(t1.area, t2.area);

            if (compared == 0) {
                return Double.compare(t1.depth, t2.depth);
            }

            return compared;
        }
    });

    double totalDeliveredTileSqM = 0;
    double totalDeliveredLaminateSqM = 0;

    @Override
    public void deliverTile(Tile tile) {

        double delivered = tile.width * tile.height;

        if (totalDeliveredTileSqM + delivered > 30) {
            throw new IllegalStateException();
        }

        tileStack.push(tile);
        deliveredTile.add(tile);
        totalDeliveredTileSqM += delivered;
        sorted.add(tile);


    }

    @Override
    public void deliverFlooring(Laminate laminate) {

        totalDeliveredLaminateSqM += laminate.length * laminate.width;

        laminateStack.push(laminate);
        deliveredLaminate.add(laminate);
    }

    @Override
    public double getDeliveredTileArea() {
        return this.totalDeliveredTileSqM;
    }

    @Override
    public boolean isDelivered(Laminate laminate) {

        return deliveredLaminate.contains(laminate);
    }

    @Override
    public void returnTile(Tile tile) {

        if (!deliveredTile.contains(tile)) {
            throw new IllegalArgumentException();
        }
        double returnTileArea = tile.height * tile.width;
        totalDeliveredTileSqM -= returnTileArea;
        deliveredTile.remove(tile);
        tileStack.remove(tile);
    }

    @Override
    public void returnLaminate(Laminate laminate) {

        if (!deliveredLaminate.contains(laminate)) {
            throw new IllegalArgumentException();
        }

        totalDeliveredLaminateSqM -= laminate.length * laminate.width;
        deliveredLaminate.remove(laminate);
        laminateStack.remove(laminate);
    }

    @Override
    public Collection<Laminate> getAllByWoodType(WoodType wood) {
        return deliveredLaminate.stream()
                .filter(l -> l.woodType.equals(wood))
                .collect(Collectors.toList());
    }

    @Override
    public Collection<Tile> getAllTilesFitting(double width, double height) {
        return deliveredTile.stream()
                .filter(t -> t.height <= height && t.width <= width)
                .collect(Collectors.toList());
    }

    @Override
    public Collection<Tile> sortTilesBySize() {
        return sorted;
    }

    @Override
    public Iterator<Laminate> layFlooring() {
        return this.laminateStack.iterator();
    }
}
