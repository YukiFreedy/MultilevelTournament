/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persistance;

/**
 *
 * @author Yuki
 */
public class Result {
    
    public enum ResultType{
       unknown, p1, p2, tie;
    }
    
    private Player p1, p2;
    
    private ResultType result;

    public Result(Player p1, Player p2, ResultType result) {
        this.p1 = p1;
        this.p2 = p2;
        this.result = result;
    }

    public Player getP1() {
        return p1;
    }

    public void setP1(Player p1) {
        this.p1 = p1;
    }

    public Player getP2() {
        return p2;
    }

    public void setP2(Player p2) {
        this.p2 = p2;
    }

    public ResultType getResult() {
        return result;
    }

    public void setResult(ResultType result) {
        this.result = result;
    }
    
    
}
