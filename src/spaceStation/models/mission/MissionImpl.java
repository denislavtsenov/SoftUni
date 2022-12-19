package spaceStation.models.mission;

import spaceStation.models.astronauts.*;
import spaceStation.models.planets.*;

import java.util.Collection;

public class MissionImpl implements Mission {


    @Override
    public void explore(Planet planet, Collection<Astronaut> astronauts) {
        Collection<String> items = planet.getItems();

        for (Astronaut astronaut : astronauts) {
            while (astronaut.canBreath() && !items.isEmpty()) {
                astronaut.breath();

                String currentItem = items.iterator().next();
                astronaut.getBag().getItems().add(currentItem);
                planet.getItems().remove(currentItem);
            }
        }
    }
}
