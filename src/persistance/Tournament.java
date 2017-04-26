/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persistance;

import java.util.ArrayList;
import java.util.Collections;

/**
 *
 * @author Yuki
 */
public class Tournament {

    private ArrayList<Player> players;
    private ArrayList<Round> rounds;
    private String name;

    public Tournament() {
        players = new ArrayList<>();
        rounds = new ArrayList<>();
    }

    public Tournament(ArrayList<Player> players, ArrayList<Round> rounds) {
        this.players = players;
        this.rounds = rounds;
    }

    public ArrayList<Player> getPlayers() {
        return players;
    }

    public void setPlayers(ArrayList<Player> players) {
        this.players = players;
    }

    public ArrayList<Round> getRounds() {
        return rounds;
    }

    public void setRound(ArrayList<Round> rounds) {
        this.rounds = rounds;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ArrayList<Player> nextBattles() {
        ArrayList<Player> ordered = new ArrayList<>();
        ArrayList<Player> woRival = new ArrayList<>();
        for (Player p : players) {
            woRival.add(p);
        }
        orderByPoints();
        for (int i = 0; i < woRival.size() && woRival.size() != 1; i++) {
            Player p = woRival.get(i);
            ordered.add(p);
            Player rival = nextRival(p, woRival);
            ordered.add(rival);
            woRival.remove(rival);
            woRival.remove(p);
            i--;
        }
        return ordered;
    }

    public Player nextRival(Player player, ArrayList<Player> woRival) {
        for (Player p : woRival) {
            if (p != player && !p.getPlayed().contains(player)) {
                return player;
            }
        }
        return null;
    }

    public void orderByPoints() {
        Collections.sort(players, (Player r1, Player r2) ->
        r1.getPoints().compareTo(r2.getPoints()));
    }
}
