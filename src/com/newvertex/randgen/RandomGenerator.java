package com.newvertex.randgen;

import com.newvertex.randgen.util.Random;
import com.newvertex.randgen.view.RootLayoutController;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class RandomGenerator extends Application {

    private static ObservableList<Integer> itemList = FXCollections.observableArrayList();
    private Stage primaryStage;

    @Override
    public void start(Stage primaryStage) throws Exception {
        this.primaryStage = primaryStage;

        initRootLayout();
    }

    private void initRootLayout() {

        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("view/RootLayout.fxml"));
            AnchorPane rootLayout = loader.load();

            RootLayoutController controller = loader.getController();
            controller.setApp(this);

            Scene scene = new Scene(rootLayout);
            primaryStage.setScene(scene);
            primaryStage.setTitle("Random Generator");
            primaryStage.show();

        } catch (IOException ex) {
            Logger.getLogger(RandomGenerator.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public ObservableList<Integer> getItemList() {
        return itemList;
    }

    public static void main(String[] args) {
        launch(args);
    }

    public void generateRandom(int start, int end, int number, boolean isMiddleSquare) {
        Random rnd = new Random(start, end);
        int seed = getInitSeed();

        if (isMiddleSquare) {
            itemList.addAll(rnd.middleSquare(seed, number));
        } else {
            for (int i = 0; i < number; i++) {
                itemList.add(rnd.randomClass());
            }
        }
    }

    private int getInitSeed() {
        int seed = 0;
        while (true) {
            Long longSeed = System.currentTimeMillis();

            String strSeed = longSeed.toString().substring(
                    longSeed.toString().length() - 4,
                    longSeed.toString().length());

            seed = Integer.parseInt(strSeed);

            if (seed < 1000) {
                seed += 1000;
            }

            if (seed % 2 != 0) {
                break;
            }
        }

        return seed;
    }
}
