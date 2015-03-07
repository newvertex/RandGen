package com.newvertex.randgen.view;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;

public class RootLayoutController implements Initializable {
    @FXML
    private CheckBox isMiddleSquareMethod;
    @FXML
    private TextField start;
    @FXML
    private TextField end;
    @FXML
    private TextField number;
    @FXML
    private ListView<Integer> listView;

    @Override
    public void initialize(URL url, ResourceBundle rb) {

    }    

    @FXML
    private void handleGenerate(ActionEvent event) {
    }

    @FXML
    private void handleClear(ActionEvent event) {
    }
    
}
