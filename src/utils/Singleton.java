/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utils;

import persistance.Database;

/**
 *
 * @author Yuki
 */
public class Singleton {
    
    private static final Database db = new Database();
    
    private Singleton(){
        
    }
    
    public static Database getDatabase(){
        return db;
    }
}
