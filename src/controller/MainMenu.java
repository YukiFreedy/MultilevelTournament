/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
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
import persistance.Round;
import persistance.Tournament;
import utils.Singleton;
import utils.WindowMaker;

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
    
    private ObservableList<Player> players;
    
    private Tournament tournament;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        playerCol.setCellValueFactory(c -> c.getValue().namePProperty());
        pointsCol.setCellValueFactory(c -> c.getValue().pointPProperty());
        positionCol.setCellValueFactory(c -> c.getValue().positionPProperty());
        players = FXCollections.observableArrayList();
        table.setItems(players);
    }    

    @Override
    public void refresh() {
        for(Player p : players) p.refresh();
    }

    @FXML
    private void onPointsXWin(KeyEvent event) {
        if(!"0123456789".contains(event.getCharacter())) event.consume();
    }

    @FXML
    private void onPointsXLose(KeyEvent event) {
        if(!"0123456789".contains(event.getCharacter())) event.consume();
    }

    @FXML
    private void onAdd(ActionEvent event) {
        if(!playerNameField.getText().isEmpty()){
            players.add(new Player(playerNameField.getText()));
        }
        refresh();
    }

    @FXML
    private void startTournamentBut(ActionEvent event) {
        tournament = new Tournament();
        ArrayList<Player> aux = new ArrayList<>();
        for(Player p : players) aux.add(p);
        tournament.setPlayers(aux);
        Round round = new Round(1);
        tournament.getRounds().add(round);
        Singleton.getDatabase().getTournaments().add(tournament);
        WindowMaker.createRoundWindow(tournament, round);
    }

    @FXML
    private void onWinMinus(ActionEvent event) {
        if(pointsXWin.getText().isEmpty()) pointsXWin.setText("1");
        pointsXWin.setText(Integer.toString(Integer.parseInt(pointsXWin.getText())-1));
    }

    @FXML
    private void onWinPlus(ActionEvent event) {
        if(pointsXWin.getText().isEmpty()) pointsXWin.setText("1");
        pointsXWin.setText(Integer.toString(Integer.parseInt(pointsXWin.getText())+1));
    }

    @FXML
    private void onLoseMinus(ActionEvent event) {
        if(pointsXLose.getText().isEmpty()) pointsXWin.setText("1");
        pointsXLose.setText(Integer.toString(Integer.parseInt(pointsXLose.getText())-1));
    }

    @FXML
    private void onLosePlus(ActionEvent event) {
        if(pointsXLose.getText().isEmpty()) pointsXWin.setText("1");
        pointsXLose.setText(Integer.toString(Integer.parseInt(pointsXLose.getText())+1));
    }
    
}
