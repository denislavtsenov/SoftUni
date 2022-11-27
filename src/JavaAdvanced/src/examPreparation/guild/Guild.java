package JavaAdvanced.src.examPreparation.guild;

import java.util.ArrayList;
import java.util.List;

public class Guild {
    private List<Player> roster;
    private String name;
    private int capacity;

    public Guild(String name, int capacity) {
        this.name = name;
        this.capacity = capacity;
        roster = new ArrayList<>();
    }

    public void addPlayer(Player player) {
        if (roster.size() < capacity) {
            roster.add(player);
        }
    }

    public boolean removePlayer(String name) {
        return roster.removeIf(player -> player.getName().equals(name));
    }

    public void promotePlayer(String name) {
        Player promotedPlayer = roster.stream().filter(player -> player.getName().equals(name)).findFirst().get();
        if (!promotedPlayer.getRank().equals("Member")) {
            promotedPlayer.setRank("Member");
        }
    }

    public void demotePlayer(String name) {
        Player demotedPlayer = roster.stream().filter(player -> player.getName().equals(name)).findFirst().get();
        if (!demotedPlayer.getRank().equals("Trial")) {
            demotedPlayer.setRank("Trial");
        }
    }

    public Player[] kickPlayersByClass(String clazz) {
        List<Player> kickPlayersList = new ArrayList<>();
        for (Player player : roster) {
            if (player.getClazz().equals(clazz)) {
                kickPlayersList.add(player);
            }
        }

        roster.removeIf(player -> player.getClazz().equals(clazz));

        Player[] players = new Player[kickPlayersList.size()];
        for (int i = 0; i < kickPlayersList.size(); i++) {
            players[i] = kickPlayersList.get(i);
        }

        return players;
    }

    public String report() {
        StringBuilder sb = new StringBuilder();
        sb.append(String.format("Players in the JavaAdvanced.src.examPreparation.guild: %s:%n", name));

        for (Player player : roster) {
            sb.append(player).append(System.lineSeparator());
        }



        return sb.toString();
    }

    public int count() {
        return roster.size();
    }
}
