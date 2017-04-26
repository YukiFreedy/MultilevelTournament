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
public class Round {
    
    private ArrayList<Result> results;
    private int roundNum;
    
    public Round() {
        results = new ArrayList<>();
    }

    public Round(int roundNum) {
        this.roundNum = roundNum;
        results = new ArrayList<>();
    }

    public Round(ArrayList<Result> results, int roundNum) {
        this.results = results;
        this.roundNum = roundNum;
    }

    public ArrayList<Result> getResults() {
        return results;
    }

    public void setResults(ArrayList<Result> results) {
        this.results = results;
    }

    public int getRoundNum() {
        return roundNum;
    }

    public void setRoundNum(int roundNum) {
        this.roundNum = roundNum;
    }
    
    
}
