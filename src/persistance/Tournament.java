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
    private int pointsXWin, pointsXLose;

    public Tournament() {
        players = new ArrayList<>();
        rounds = new ArrayList<>();
        pointsXWin = 1;
        pointsXLose = -1;
    }

    public Tournament(ArrayList<Player> players, ArrayList<Round> rounds, String name, int pointsXWin, int pointsXLose) {
        this.players = players;
        this.rounds = rounds;
        this.name = name;
        this.pointsXWin = pointsXWin;
        this.pointsXLose = pointsXLose;
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
        for (int i = 0; woRival.size() > 1; ) {
            Player p = woRival.get(i);
            ordered.add(p);
            Player rival = nextRival(p, woRival);
            if(rival != null) ordered.add(rival);
            else ordered.remove(p);
            woRival.remove(p);
            woRival.remove(rival);
        }
        return ordered;
    }

    public Player nextRival(Player player, ArrayList<Player> woRival) {
        for (Player p : woRival) {
            if (p != player && !p.getPlayed().contains(player)) {
                return p;
            }
        }
        return null;
    }

    public void orderByPoints() {
        Collections.sort(players, (Player r1, Player r2) ->
        r2.getPoints().compareTo(r1.getPoints()));
        for(Player p : players) p.setPosition(players.indexOf(p)+1);
    }

    public int getPointsXWin() {
        return pointsXWin;
    }

    public void setPointsXWin(int pointsXWin) {
        this.pointsXWin = pointsXWin;
    }

    public int getPointsXLose() {
        return pointsXLose;
    }

    public void setPointsXLose(int pointsXLose) {
        this.pointsXLose = pointsXLose;
    }
    
    
}
