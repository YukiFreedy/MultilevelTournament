/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import javafx.application.Application;
import javafx.stage.Stage;
import utils.WindowMaker;

/**
 *
 * @author Yuki
 */
public class init extends Application{
    
    public static void main(String[] args) {
        launch();
    }
    
    @Override
    public void start(Stage stage) throws Exception {
        WindowMaker.createMainMenu();
    }
    
}
