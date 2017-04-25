/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utils;

import controller.MyWindow;
import java.util.ArrayList;
import javafx.event.EventHandler;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;

/**
 *
 * @author Yuki
 */
public class WindowAux {
    
    private ArrayList<MyWindow> openedWindows;
    
    public WindowAux(){
        openedWindows = new ArrayList<>();
    }
    
    public void addWindow(MyWindow window, Stage stage){
        openedWindows.add(window);
        stage.setOnCloseRequest(new EventHandler<WindowEvent>() {
                @Override
                public void handle(WindowEvent event) {
                    openedWindows.remove(window);
                }
            });
    }

    public ArrayList<MyWindow> getOpenedWindows() {
        return openedWindows;
    }
    
}
