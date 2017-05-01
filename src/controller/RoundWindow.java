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
import javafx.collections.ObservableArray;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.HPos;
import javafx.geometry.VPos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.RowConstraints;
import persistance.Player;
import persistance.Result;
import persistance.Round;
import persistance.Tournament;
import utils.ButtonHandler;

/**
 * FXML Controller class
 *
 * @author Yuki
 */
public class RoundWindow implements Initializable, MyWindow {

    @FXML
    private Label roundLabel;
    @FXML
    private GridPane grid;

    private Round round;
    @FXML
    private TableView<Player> table;
    @FXML
    private TableColumn<Player, String> colName;
    @FXML
    private TableColumn<Player, String> ColPoints;
    @FXML
    private TableColumn<Player, String> colPosition;
    @FXML
    private ScrollPane container;

    private ObservableList<Player> players;

    private Tournament t;

    private Round r;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        colName.setCellValueFactory(c -> c.getValue().namePProperty());
        ColPoints.setCellValueFactory(c -> c.getValue().pointPProperty());
        colPosition.setCellValueFactory(c -> c.getValue().positionPProperty());
    }

    public void init(Tournament t, Round r) {
        this.t = t;
        this.r = r;
        for(Player p : t.getPlayers()) p.refresh();
        players = FXCollections.observableArrayList(t.getPlayers());

        table.setItems(players);

        roundLabel.setText("Round " + r.getRoundNum());
        GridPane gridPlayers = new GridPane();
        container.setContent(gridPlayers);
        gridPlayers.setVgap(20);

        ColumnConstraints c0 = new ColumnConstraints();
        c0.setHalignment(HPos.CENTER);
        c0.setPercentWidth(200 / 5);
        ColumnConstraints c1 = new ColumnConstraints();
        c1.setHalignment(HPos.CENTER);
        c1.setPercentWidth(100 / 5);
        ColumnConstraints c2 = new ColumnConstraints();
        c2.setHalignment(HPos.CENTER);
        c2.setPercentWidth(200 / 5);

        int numberBattles = 0;
        numberBattles = t.getPlayers().size() / 2;
        ArrayList<RowConstraints> cons = new ArrayList<>();
        for (int i = 0; i < numberBattles; i++) {
            RowConstraints r0 = new RowConstraints();
            r0.setPercentHeight(100 / numberBattles);
            r0.setValignment(VPos.CENTER);
            cons.add(r0);
        }
        gridPlayers.getRowConstraints().addAll(cons);
        gridPlayers.getColumnConstraints().addAll(c0, c1, c2);
        ArrayList<Player> order = t.nextBattles();
        for (int i = 0; i < order.size(); i += 2) {
            Button btn = new Button(order.get(i).getName());
            btn.setPrefHeight(100);
            btn.setPrefWidth(200);
            Result result = new Result(order.get(i), order.get(i + 1), Result.ResultType.unknown);
            r.getResults().add(result);
            Button btn2 = new Button(order.get(i + 1).getName());
            btn2.setPrefHeight(100);
            btn2.setPrefWidth(200);
            new ButtonHandler(btn, result, 1, btn2);
            new ButtonHandler(btn2, result, 2, btn);

            gridPlayers.add(btn, 0, i / 2);
            gridPlayers.add(new Label("VS"), 1, i / 2);
            gridPlayers.add(btn2, 2, i / 2);
        }
    }

    @Override
    public void refresh() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @FXML
    private void onNextRound(ActionEvent event) {
        for (Result re : r.getResults()) {
            if (re.getResult() == Result.ResultType.p1) {
                re.getP1().winGame(t);
                re.getP2().loseGame(t);
            } else if (re.getResult() == Result.ResultType.p2) {
                re.getP2().winGame(t);
                re.getP1().loseGame(t);
            }
            re.getP1().getPlayed().add(re.getP2());
            re.getP2().getPlayed().add(re.getP1());
        }
        t.orderByPoints();
        Round newRound = new Round(r.getRoundNum()+1);
        init(t, newRound);
    }

    @FXML
    private void onEndTournament(ActionEvent event) {
    }

}
