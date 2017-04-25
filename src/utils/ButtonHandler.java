/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utils;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import persistance.Result;

/**
 *
 * @author Yuki
 */
public class ButtonHandler {

    private Button btn;
    private Result r;

    public ButtonHandler(Button btn, Result r, int type, Button contrary) {
        this.btn = btn;
        this.r = r;
        if (type == 1) {
            btn.setOnAction(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent event) {
                    r.setResult(Result.ResultType.p1);
                    btn.setDisable(true);
                    contrary.setDisable(false);
                }
            });
        } else {
            btn.setOnAction(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent event) {
                    r.setResult(Result.ResultType.p2);
                    btn.setDisable(true);
                    contrary.setDisable(false);
                }
            });
        }

    }

}
