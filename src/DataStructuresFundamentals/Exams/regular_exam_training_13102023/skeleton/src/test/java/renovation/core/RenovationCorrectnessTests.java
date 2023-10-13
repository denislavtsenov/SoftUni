package renovation.core;

import renovation.models.Laminate;
import renovation.models.Tile;
import renovation.models.WoodType;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.hasItems;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

public class RenovationCorrectnessTests {

    private Renovation renovationService;

    @Before
    public void setup() {
        this.renovationService = new RenovationImpl();
    }

    @Test
    public void testDeliveredTileAreIncreasesWhenDeliveringTiles() {
        assertThat(this.renovationService.getDeliveredTileArea(), is(0.0));

        Tile t1 = new Tile(2, 2, 0.5);
        Tile t2 = new Tile(3, 3, 0.5);
        this.renovationService.deliverTile(t1);
        this.renovationService.deliverTile(t2);

        assertThat(this.renovationService.getDeliveredTileArea(), is(13.0));
    }

    @Test
    public void testReturnTileThrowsExceptionWhenMissing() {
        Tile t1 = new Tile(2, 2, 0.5);
        Tile t2 = new Tile(3, 3, 0.5);
        this.renovationService.deliverTile(t1);

        assertThrows(IllegalArgumentException.class, () -> this.renovationService.returnTile(t2));
    }

    @Test
    public void testGetAllByWoodType() {
        Laminate l1 = new Laminate(2.2, 0.2, WoodType.OAK);
        Laminate l2 = new Laminate(2.2, 0.3, WoodType.OAK);
        Laminate l3 = new Laminate(2.5, 0.2, WoodType.CHERRY);

        this.renovationService.deliverFlooring(l1);
        this.renovationService.deliverFlooring(l2);
        this.renovationService.deliverFlooring(l3);

        Collection<Laminate> allByWoodType = this.renovationService.getAllByWoodType(WoodType.OAK);

        assertThat(allByWoodType, hasItems(l1, l2));
    }

    @Test
    public void testReturnTile() {
        verifyCorrectness0();
        renovationService = new RenovationImpl();

        List<Tile> tiles = new ArrayList<>();

        for (int i = 0; i < 10000; i++) {
            double value = i * 0.000001;
            tiles.add(new Tile(value, value, value));

            this.renovationService.deliverTile(tiles.get(i));
        }

        long start = System.currentTimeMillis();
        for (int i = 0; i < 10000; i++) {
            this.renovationService.returnTile(tiles.get(i));
        }
        long stop = System.currentTimeMillis();

        assertTrue(stop - start < 150);
    }

    private void verifyCorrectness0() {
        Tile t1 = new Tile(2, 2, 0.5);

        this.renovationService.deliverTile(t1);

        assertEquals(4, this.renovationService.getDeliveredTileArea(), 0.0);

        this.renovationService.returnTile(t1);

        assertEquals(0, this.renovationService.getDeliveredTileArea(), 0.0);
    }


    @Test
    public void testReturnLaminate() {
        List<Laminate> laminates = new ArrayList<>();

        for (int i = 0; i < 10000; i++) {
            laminates.add(new Laminate(i, i, WoodType.OAK));

            this.renovationService.deliverFlooring(laminates.get(i));
        }

        long start = System.currentTimeMillis();
        for (int i = 0; i < 10000; i++) {
            Iterator<Laminate> laminateIterator = this.renovationService.layFlooring();
            while (laminateIterator.hasNext()) {
                laminateIterator.next();
            }
        }
        long stop = System.currentTimeMillis();

        assertTrue(stop - start < 420);
    }

    private void verifyCorrectness1() {
        Laminate l1 = new Laminate(2.1, 0.4, WoodType.OAK);
        Laminate l2 = new Laminate(2.2, 0.4, WoodType.OAK);
        Laminate l3 = new Laminate(2.3, 0.4, WoodType.OAK);
        Laminate l4 = new Laminate(2.4, 0.4, WoodType.OAK);

        List<Laminate> expected = List.of(l4, l3, l2, l1);
        Iterator<Laminate> expectedIterator = expected.iterator();

        this.renovationService.deliverFlooring(l1);
        this.renovationService.deliverFlooring(l2);
        this.renovationService.deliverFlooring(l3);
        this.renovationService.deliverFlooring(l4);

        Iterator<Laminate> laminateIterator = this.renovationService.layFlooring();

        while (laminateIterator.hasNext()) {
            assertEquals(expectedIterator.next(), laminateIterator.next());
        }

        assertFalse(expectedIterator.hasNext());
    }

    @Test
    public void testSortTilesByDepth() {
        verifyCorrectness2();
        this.renovationService = new RenovationImpl();

        List<Tile> tiles = new ArrayList<>();

        for (int i = 0; i < 10000; i++) {
            double value = i * 0.000001;
            tiles.add(new Tile(value, value, value % 100));

            this.renovationService.deliverTile(tiles.get(i));
        }

        long start = System.currentTimeMillis();
        for (int i = 0; i < 10000; i++) {
            this.renovationService.sortTilesBySize();
        }
        long stop = System.currentTimeMillis();

        assertTrue(stop - start < 4400);
    }

    private void verifyCorrectness2() {
        Tile t1 = new Tile(1, 1, 0.5);
        Tile t2 = new Tile(2, 2, 0.5);
        Tile t3 = new Tile(3, 3, 0.7);
        Tile t4 = new Tile(4, 1, 0.8);

        this.renovationService.deliverTile(t1);
        this.renovationService.deliverTile(t2);
        this.renovationService.deliverTile(t3);
        this.renovationService.deliverTile(t4);

        Collection<Tile> tilesBySize = this.renovationService.sortTilesBySize();

        assertEquals(tilesBySize.size(), 4);

        List<Tile> expected = List.of(t1, t2, t4, t3);
        Iterator<Tile> actualIterator = tilesBySize.iterator();
        int i = 0;

        while (actualIterator.hasNext()) {
            assertEquals(expected.get(i++), actualIterator.next());
        }
    }
}

