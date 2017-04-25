/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utils;

import persistance.Database;
import persistance.Tournament;

/**
 *
 * @author Yuki
 */
public class Factory {
    
    public static Database createDatabase(){
        return new Database();
    }
    
    public static Tournament createTournament(){
        return new Tournament();
    }
    
}
