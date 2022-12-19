package viceCity.core;

import viceCity.core.interfaces.Controller;
import viceCity.models.guns.Gun;
import viceCity.models.guns.Pistol;
import viceCity.models.guns.Rifle;
import viceCity.models.neighbourhood.GangNeighbourhood;
import viceCity.models.neighbourhood.Neighbourhood;
import viceCity.models.players.CivilPlayer;
import viceCity.models.players.MainPlayer;
import viceCity.models.players.Player;
import viceCity.repositories.interfaces.GunRepository;
import viceCity.repositories.interfaces.Repository;

import java.util.ArrayList;
import java.util.List;

import static viceCity.common.ConstantMessages.*;

public class ControllerImpl implements Controller {
    private Repository<Gun> gunRepository;
    private List<Player> playerRepository;

    public ControllerImpl() {
        gunRepository = new GunRepository();
        playerRepository = new ArrayList<>();
    }

    @Override
    public String addPlayer(String name) {
        Player player = new CivilPlayer(name);
        playerRepository.add(player);

        return String.format(PLAYER_ADDED, name);
    }

    @Override
    public String addGun(String type, String name) {
        Gun gun;

        if (type.equals("Pistol")) {
            gun = new Pistol(name);
        } else if (type.equals("Rifle")) {
            gun = new Rifle(name);
        } else {
            return GUN_TYPE_INVALID;
        }

        gunRepository.add(gun);
        return String.format(GUN_ADDED, name, type);
    }

    @Override
    public String addGunToPlayer(String name) {

        Player player;
        Gun firstGun = gunRepository.getModels().iterator().next();

        if (firstGun == null) {
            return GUN_QUEUE_IS_EMPTY;
        }

        player = new CivilPlayer(name);

        if (name.equals("Vercetti")) {
            player = new MainPlayer();
            player.getGunRepository().add(firstGun);
            return String.format(GUN_ADDED_TO_MAIN_PLAYER, firstGun.getName(), name);
        }

        if (!playerRepository.contains(player)) {
            return CIVIL_PLAYER_DOES_NOT_EXIST;
        }

        player.getGunRepository().add(firstGun);
        return String.format(GUN_ADDED_TO_CIVIL_PLAYER, firstGun.getName(), name);
    }

    @Override
    public String fight() {
        Player player = new MainPlayer();

        Neighbourhood neighbourhood = new GangNeighbourhood();
        neighbourhood.action(player, playerRepository);
        return null;
    }
}
