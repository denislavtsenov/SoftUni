package viceCity.models.neighbourhood;

import viceCity.models.guns.Gun;
import viceCity.models.players.Player;

import java.util.Collection;
import java.util.List;

public class GangNeighbourhood implements Neighbourhood {


    @Override
    public void action(Player mainPlayer, Collection<Player> civilPlayers) {
        int dead = 0;
        List<Gun> mainPlayerGunCollection = mainPlayer.getGunRepository().getModels().stream().toList();

        while (mainPlayer.isAlive()) {
            while (!mainPlayerGunCollection.isEmpty()) {
                for (Gun gun : mainPlayerGunCollection) {
                    for (Player civilPlayer : civilPlayers) {
                        while (gun.canFire() && civilPlayer.isAlive()) {
                            int points = gun.fire();
                            civilPlayer.takeLifePoints(points);

                            if (civilPlayer.getLifePoints() == 0) {
                                dead++;
                                civilPlayers.remove(civilPlayer);
                            }
                        }
                    }
                }
            }
            if (!civilPlayers.isEmpty()) {
                for (Player civilPlayer : civilPlayers) {
                    Collection<Gun> civilPlayerGunCollection = civilPlayer.getGunRepository().getModels();

                    if (!civilPlayerGunCollection.isEmpty()) {
                        for (Gun gun : civilPlayerGunCollection) {
                            while (gun.canFire() && mainPlayer.isAlive()) {
                                int points = gun.fire();
                                mainPlayer.takeLifePoints(points);
                            }
                        }
                    }
                }
            }
        }
    }
}

