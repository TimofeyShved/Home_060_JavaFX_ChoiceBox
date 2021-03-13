package sample;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

import javax.swing.*;

public class Main extends Application {


    @Override
    public void start(Stage primaryStage) throws Exception{
        //Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));
        primaryStage.setTitle("ChoiceBox"); // заголовок формы

        // выборка цветов из специального набора
        ColorPicker cp = new ColorPicker(Color.WHITE); // создание
        cp.setTranslateX(100); // вправо на 100 пикселей, расположение

        ChoiceBox choiceBox = new ChoiceBox(); // наш набор выбора
        choiceBox.setItems(FXCollections.observableArrayList(
                "RED", "GREEN", "YELLOW", "BLUE", "BLACK", "WHITE" // закидываем строчки с указанным цветом
        ));

        // создаем квадрат
        Rectangle rectangle = new Rectangle(200,200,Color.WHITE);
        rectangle.setTranslateX(100);
        rectangle.setTranslateY(100);

        // действие нашего набора
        choiceBox.setOnAction(event -> {
            rectangle.setFill(Color.web((String) choiceBox.getValue()));
        });

        // действие на ColorPicker
        cp.setOnAction(event -> {
            rectangle.setFill(cp.getValue());
        });

        // основное
        Pane root = new Pane(); // создание основной панели
        root.getChildren().addAll(choiceBox, rectangle, cp); // добавление на неё наших элементов

        // добавление на сцены | на форму
        Scene scene = new Scene(root, 500, 400);
        primaryStage.setScene(scene);  // размер формы и сцена
        primaryStage.show(); // отобразить
    }


    public static void main(String[] args) {
        launch(args);
    }
}