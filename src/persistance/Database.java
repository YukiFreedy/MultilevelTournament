/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persistance;

import java.util.ArrayList;

/**
 *
 * @author Yuki
 */
public class Database {
    
    private ArrayList<Tournament> tournaments;

    public Database() {
        tournaments = new ArrayList<>();
    }
    
    public Database(ArrayList<Tournament> tournaments) {
        this.tournaments = tournaments;
    }

    public ArrayList<Tournament> getTournaments() {
        return tournaments;
    }

    public void setTournaments(ArrayList<Tournament> tournaments) {
        this.tournaments = tournaments;
    }
    
    
}
