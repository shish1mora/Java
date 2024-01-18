package com.example.laba7java;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javafx.geometry.Insets;
import javafx.scene.layout.GridPane;

public class Program extends Application {

    private TextField side1Field, side2Field, angleField, perimeterResult, areaResult;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Вычисление периметра и площади треугольника");

        GridPane grid = new GridPane();
        grid.setPadding(new Insets(10, 10, 10, 10));
        grid.setVgap(5);
        grid.setHgap(5);

        Label side1Label = new Label("Введите значение первой стороны:");
        GridPane.setConstraints(side1Label, 0, 0);
        side1Field = new TextField();
        GridPane.setConstraints(side1Field, 1, 0);

        Label side2Label = new Label("Введите значение второй стороны:");
        GridPane.setConstraints(side2Label, 0, 1);
        side2Field = new TextField();
        GridPane.setConstraints(side2Field, 1, 1);

        Label angleLabel = new Label("Введите значение угла между сторонами в радианах:");
        GridPane.setConstraints(angleLabel, 0, 2);
        angleField = new TextField();
        GridPane.setConstraints(angleField, 1, 2);

        Button calculateButton = new Button("Вычислить");
        GridPane.setConstraints(calculateButton, 0, 3);
        calculateButton.setOnAction(e -> calculate());

        Button clearButton = new Button("Очистить");
        GridPane.setConstraints(clearButton, 1, 3);
        clearButton.setOnAction(e -> clear());

        Button closeButton = new Button("Закрыть");
        GridPane.setConstraints(closeButton, 2, 3);
        closeButton.setOnAction(e -> primaryStage.close());

        Label perimeterLabel = new Label("Периметр треугольника:");
        GridPane.setConstraints(perimeterLabel, 0, 4);
        perimeterResult = new TextField();
        perimeterResult.setEditable(false);
        GridPane.setConstraints(perimeterResult, 1, 4);

        Label areaLabel = new Label("Площадь треугольника:");
        GridPane.setConstraints(areaLabel, 0, 5);
        areaResult = new TextField();
        areaResult.setEditable(false);
        GridPane.setConstraints(areaResult, 1, 5);

        grid.getChildren().addAll(side1Label, side1Field, side2Label, side2Field,
                angleLabel, angleField, calculateButton, clearButton,
                closeButton, perimeterLabel, perimeterResult,
                areaLabel, areaResult);

        Scene scene = new Scene(grid, 400, 250);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private void calculate() {
        double side1 = Double.parseDouble(side1Field.getText());
        double side2 = Double.parseDouble(side2Field.getText());
        double angle = Double.parseDouble(angleField.getText());

        Calculations calculations = new Calculations();
        double perimeter = calculations.calculatePerimeter(side1, side2, angle);
        double area = calculations.calculateArea(side1, side2, angle);

        perimeterResult.setText(String.valueOf(perimeter));
        areaResult.setText(String.valueOf(area));
    }

    private void clear() {
        side1Field.clear();
        side2Field.clear();
        angleField.clear();
        perimeterResult.clear();
        areaResult.clear();
    }
}
