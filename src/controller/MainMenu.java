/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.beans.binding.Bindings;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyEvent;
import persistance.Player;

/**
 * FXML Controller class
 *
 * @author Yuki
 */
public class MainMenu implements Initializable, MyWindow{

    @FXML
    private TableView<Player> table;
    @FXML
    private TableColumn<Player, String> playerCol;
    @FXML
    private TableColumn<Player, String> pointsCol;
    @FXML
    private TableColumn<Player, String> positionCol;
    @FXML
    private Label onGoing;
    @FXML
    private TextField playerNameField;
    @FXML
    private TextField pointsXWin;
    @FXML
    private Button winPlus;
    @FXML
    private TextField pointsXLose;
    @FXML
    private TextField tournamentNameField;
    @FXML
    private Button startTournamentBut;
    
    private ObservableList players;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        playerCol.setCellValueFactory(c -> c.getValue().namePProperty());
        pointsCol.setCellValueFactory(c -> c.getValue().pointPProperty());
        positionCol.setCellValueFactory(c -> c.getValue().positionPProperty());
    }    

    @Override
    public void refresh() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @FXML
    private void onPointsXWin(KeyEvent event) {
    }

    @FXML
    private void onPointsXLose(KeyEvent event) {
    }

    @FXML
    private void onAdd(ActionEvent event) {
    }

    @FXML
    private void startTournamentBut(ActionEvent event) {
    }

    @FXML
    private void onWinMinus(ActionEvent event) {
    }

    @FXML
    private void onWinPlus(ActionEvent event) {
    }

    @FXML
    private void onLoseMinus(ActionEvent event) {
    }

    @FXML
    private void onLosePlus(ActionEvent event) {
    }
    
}
