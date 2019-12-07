package com.kodilla.project1;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;

import java.awt.*;
import java.util.LinkedList;
import java.util.List;


public class Board extends Parent {
    private final Image redPlayer = new Image("file:\\project1\\src\\main\\resources\\redCircleOuterline.png");
    private final Image bluePlayer = new Image("file:\\project1\\src\\main\\resources\\blueCircleOuterline.png");
    private final Image blackBg = new Image("file:\\project1\\src\\main\\resources\\blackBg.png");
    List<Button> redButton = new LinkedList<Button>();
    List<Button> blueButton = new LinkedList<Button>();
    List<Button> whiteButton = new LinkedList<Button>();
    GridPane gridPane;

    public Board(GridPane gridPane)  {
        this.gridPane = gridPane;
        generateRedButton();
        generateBlueButton();
        generateBlackButton();
    }
    private void generateRedButton () {
        for (int y = 0; y<3; y++) {
            for (int x = 0; x<8; x++) {
                Button button = new Button();
                button.setStyle("-fx-background-color: #000");
                button.setGraphic(new ImageView(redPlayer));
                button.setMaxSize(100,100);
                if (y <= 2 && (x + y) % 2 != 0) {
                    gridPane.add(button,x,y);

                }
            }
        }
    }
    private void generateBlueButton () {
        for (int y = 5; y<8; y++) {
            for (int x = 0; x<8; x++){
                Button button = new Button();
                button.setStyle("-fx-background-color: #000");
                button.setGraphic(new ImageView(bluePlayer));
                button.setMaxSize(100,100);
                if(y >= 5 && (x + y) % 2 != 0){
                    gridPane.add(button,x,y);
                }
            }
        }
    }
    private void generateBlackButton () {
        for (int y = 3; y<5; y++) {
            for (int x = 0; x<8; x++){
                Button button = new Button();
                button.setMaxSize(100,100);
                button.setStyle("-fx-background-color: #000");
                if(y <= 5 && (x + y) % 2 != 0){
                    gridPane.add(button,x,y);
                }
            }
        }
    }

}
