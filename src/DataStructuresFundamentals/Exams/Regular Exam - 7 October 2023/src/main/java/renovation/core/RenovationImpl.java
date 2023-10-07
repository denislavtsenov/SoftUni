package renovation.core;

import renovation.models.Laminate;
import renovation.models.Tile;
import renovation.models.WoodType;

import java.util.*;

public class RenovationImpl implements Renovation {

    List<Tile> deliveredTiles = new ArrayList<>();
    List<Laminate> deliveredLaminates = new ArrayList<>();

    Double totalDeliveredArea = 0.0;

    @Override
    public void deliverTile(Tile tile) {

        double tileArea = tile.height * tile.width;
        double totalTileArea = getDeliveredTileArea() + tileArea;

        if (totalTileArea > 30) {
            throw new IllegalArgumentException();
        }

        totalDeliveredArea += totalTileArea;
        deliveredTiles.add(tile);
    }

    @Override
    public void deliverFlooring(Laminate laminate) {
        deliveredLaminates.add(laminate);
    }

    @Override
    public double getDeliveredTileArea() {

        return totalDeliveredArea;
    }

    @Override
    public boolean isDelivered(Laminate laminate) {
        return deliveredLaminates.contains(laminate);
    }

    @Override
    public void returnTile(Tile tile) {

        if (!deliveredTiles.contains(tile)) {
            throw new IllegalArgumentException("Tile was never delivered.");
        }
        deliveredTiles.remove(tile);
    }

    @Override
    public void returnLaminate(Laminate laminate) {
        if (!deliveredLaminates.contains(laminate)) {
            throw new IllegalArgumentException("Laminate was never delivered.");
        }
        deliveredLaminates.remove(laminate);
    }

    @Override
    public Collection<Laminate> getAllByWoodType(WoodType wood) {
        List<Laminate> result = new ArrayList<>();
        for (Laminate laminate : deliveredLaminates) {
            if (laminate.woodType == wood) {
                result.add(laminate);
            }
        }
        return result;
    }

    @Override
    public Collection<Tile> getAllTilesFitting(double width, double height) {
        List<Tile> result = new ArrayList<>();
        for (Tile tile : deliveredTiles) {
            if (tile.width <= width && tile.height <= height) {
                result.add(tile);
            }
        }
        return result;
    }

    @Override
    public Collection<Tile> sortTilesBySize() {
       return null;
    }

    @Override
    public Iterator<Laminate> layFlooring() {
        Collections.reverse(deliveredLaminates);
        return deliveredLaminates.iterator();
    }
}
