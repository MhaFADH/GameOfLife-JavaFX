package com.gof.gameoflife;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.io.IOException;
import java.util.Arrays;

import static javafx.scene.paint.Color.*;

public class Main extends Application {

    public static boolean swtch;

    public static int[][] basedTable;
    public static Cell[][] cellTable;

    @Override
    public void start(Stage stage) throws IOException, InterruptedException {
        basedTable = new int[80][80];
        Behaviors bh = new Behaviors();
        swtch = true;
        stage.setResizable(true);
        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("hello-view.fxml"));
        Pane pane = new Pane();
        Scene scene = new Scene(pane, 800, 800);
        Button btn =  new Button();
        HBox hbx = new HBox();
        btn.setText("Off");
        hbx.getChildren().add(btn);
        pane.setStyle("-fx-background-color: LightGray");
        GridPane gridPane = new GridPane();
        gridPane.setHgap(1);
        gridPane.setVgap(1);
        scene.setFill(DARKGRAY);
        pane.getChildren().addAll(gridPane,hbx);
        cellTable = new Cell[80][80];

        for(int i = 0; i<80 ; i++){
            for(int j = 0; j<80 ; j++){
                cellTable[i][j] = new Cell(i,j);
                gridPane.add(cellTable[i][j],i,j);
            }
        }

        stage.setTitle("GoF");
        stage.setScene(scene);
        stage.show();

       /* //cellTable[10][23].alive();
        cellTable[10][24].alive();
        cellTable[10][22].alive();
        cellTable[10][23].alive();
        cellTable[9][23].alive();
        cellTable[11][24].alive();
        cellTable[79][0].alive();
        cellTable[79][1].alive();
        //basedTable[10][23]=1;
        basedTable[10][24]=1;
        basedTable[11][24]=1;
        basedTable[79][0]=1;
        basedTable[79][1]=1;
        basedTable[10][22]=1;
        basedTable[10][23]=1;
        basedTable[9][23]=1;*/

        bh.start();


        Timeline tl = new Timeline(new KeyFrame(Duration.millis(100), new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                System.out.println("Intl");

                for(int i = 0; i<80 ; i++){
                    for(int j = 0; j<80;j++){
                        if(basedTable[i][j]==1){
                            cellTable[i][j].alive();
                            //System.out.println(cellTable[i][j].isAlive());

                        }
                        if(basedTable[i][j]==0){
                            cellTable[i][j].dead();

                        }

                    }
                }

                synchronized (bh){
                    bh.notify();
                }
                //bh.process(table);

            }
        }));
        tl.setCycleCount(Timeline.INDEFINITE);
        tl.play();

        btn.setOnMouseClicked(e->{
            if(swtch) {
                btn.setText("On");
                swtch = false;
                tl.pause();
                return;
            }
            /*synchronized (bh){
                bh.start();
                bh.notify();
            }*/
            btn.setText("Off");
            tl.play();
            swtch = true;
        });


    }

    public static void main(String[] args) {
        launch();
    }
}