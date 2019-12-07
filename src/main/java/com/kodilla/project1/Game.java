package com.kodilla.project1;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.event.EventHandler;
import javafx.geometry.Orientation;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.scene.image.Image;



public class Game extends Application {

    private Image imageBack = new Image("file:\\project1\\src\\main\\resources\\Warcaby700px.png");
    private final Image bluePlayer = new Image("file:\\project1\\src\\main\\resources\\bluecircle.png");
    private final Image redPlayer = new Image("file:\\project1\\src\\main\\resources\\redcircle.png");
    private FlowPane redPiece = new FlowPane(Orientation.HORIZONTAL);
    private FlowPane bluePiece = new FlowPane(Orientation.HORIZONTAL);
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        BackgroundSize backgroundSize = new BackgroundSize(800 , 800, false, false, false, false);
        BackgroundImage backgroundImage = new BackgroundImage(imageBack, BackgroundRepeat.NO_REPEAT,BackgroundRepeat.NO_REPEAT,BackgroundPosition.DEFAULT,backgroundSize);
        Background background = new Background(backgroundImage);

        Button newGame = new Button("New Game");
        Button score = new Button("Score");
        Button exit = new Button("Exit");
        exit.setOnAction(event -> Platform.exit());

        newGame.setPrefSize(100.00,50.00);
        score.setPrefSize(100.00,50.00);
        exit.setPrefSize(100.00,50.00);
        GridPane gridPane = new GridPane();
        Board board = new Board(gridPane);
        gridPane.setGridLinesVisible(false);
        for (int x=0; x<8; x++) {
            ColumnConstraints columnConstraints = new ColumnConstraints(100);
            columnConstraints.setHgrow(Priority.ALWAYS);
            columnConstraints.setFillWidth(true);
            gridPane.getColumnConstraints().add(columnConstraints);

        }

        for (int y=0; y<8; y++) {
            RowConstraints row = new RowConstraints(100);
            row.setVgrow(Priority.ALWAYS);
            row.setFillHeight(true);
            gridPane.getRowConstraints().add(row);
        }
        RowConstraints row50 = new RowConstraints(50);
        gridPane.getRowConstraints().add(row50);
        //gridPane.setAlignment(Pos.TOP_CENTER);
        gridPane.setBackground(background);
        gridPane.add(newGame, 0,8);
        gridPane.add(score, 1,8);
        gridPane.add(exit, 2,8);
        Scene scene = new Scene(board.gridPane,800,850, Color.BLACK);

        newGame.setOnAction(n -> {
            primaryStage.close();
            primaryStage.setScene(scene);
            primaryStage.show();
        });
        Button button = new Button();
        button.setOnDragDetected(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {

            }
        });

        primaryStage.setTitle("Warcaby");
        primaryStage.setScene(scene);
        primaryStage.show();
    }


}
