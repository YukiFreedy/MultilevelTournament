/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utils;

import controller.MainMenu;
import controller.MyWindow;
import controller.RoundWindow;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;
import persistance.Round;
import persistance.Tournament;

/**
 *
 * @author Yuki
 */
public class WindowMaker {
    
    private static final WindowAux openedWindows = new WindowAux();
    
    public static MainMenu createMainMenu(){
        MainMenu con = null;
        try {
            FXMLLoader myLoader = new FXMLLoader(Factory.class.getResource("/controller/MainMenu.fxml"));
            Parent root = (Parent) myLoader.load();
            con = myLoader.<MainMenu>getController();
            Stage stage = new Stage();
            Scene scene = new Scene(root);
            stage.setOnCloseRequest(new EventHandler<WindowEvent>() {
                @Override
                public void handle(WindowEvent event) {
                    WindowMaker.closeAll();
                }
            });
            openedWindows.addWindow((MyWindow) con, stage);
            stage.setTitle("Menu Principal");
            stage.setScene(scene);
            stage.setResizable(false);
            stage.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return con;
    }
    
    public static RoundWindow createRoundWindow(Tournament t, Round r){
        RoundWindow con = null;
        try {
            FXMLLoader myLoader = new FXMLLoader(Object.class.getResource("/controller/RoundWindow.fxml"));
            Parent root = (Parent) myLoader.load();
            con = myLoader.<RoundWindow>getController();
            Scene scene = new Scene(root);
            Stage stage = new Stage();
            stage.setScene(scene);
            openedWindows.addWindow((MyWindow) con, stage);
            con.init(t, r);
            stage.setTitle("Seleccionar Cliente y Coche");
            stage.setResizable(true);
            stage.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return con;
    }
    
    private static void closeAll(){
        
    }
}
