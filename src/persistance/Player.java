/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persistance;

import java.util.ArrayList;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

/**
 *
 * @author Yuki
 */
public class Player {
    
    private String name;
    private Integer points;
    private ArrayList<Player> played;
    private int position;
    
    private final StringProperty nameP = new SimpleStringProperty();
    private final StringProperty pointP = new SimpleStringProperty();
    private final StringProperty positionP = new SimpleStringProperty();

    public Player() {
        
    }
    
    public Player(String name) {
        this.name = name;
        played = new ArrayList<>();
        points = 0;
        position = 0;
    }

    public Player(String name, Integer points, ArrayList<Player> played, int position) {
        this.name = name;
        this.points = points;
        this.played = played;
        this.position = position;
    }

    

    public StringProperty namePProperty() {
        return nameP;
    }
    
    public StringProperty pointPProperty() {
        return pointP;
    }
    
    public StringProperty positionPProperty() {
        return positionP;
    }
    
    public void refresh(){
        nameP.set(name);
        pointP.set(Integer.toString(points));
        positionP.set(Integer.toString(position));
    }
    
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getPoints() {
        return points;
    }

    public void setPoints(int points) {
        this.points = points;
    }

    public ArrayList<Player> getPlayed() {
        return played;
    }

    public void setPlayed(ArrayList<Player> played) {
        this.played = played;
    }

    public int getPosition() {
        return position;
    }

    public void setPosition(int position) {
        this.position = position;
    }
    
    
}
