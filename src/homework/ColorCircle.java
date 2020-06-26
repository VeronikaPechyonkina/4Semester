package homework;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;

public class ColorCircle extends Application {

    public static void main(String[] args) {
        Application.launch(args); }


    @Override
    public void start(Stage Stage) {
        Scene  scene = new Scene(initInterfase());
        Stage.setScene(scene);
        Stage.setTitle("Color Circle");
        Stage.show();
    }

    private HBox initInterfase() {
        Label rad = new Label("Радиус");
        Label circ = new Label("Круг");
        Label back = new Label("Фон");
        Slider sr = new Slider(0, 100, 50);

        StackPane right = new StackPane();
        Circle colcirc = new Circle(50);

        ColorPicker circleColor = new ColorPicker();
        ColorPicker BackgroundColor = new ColorPicker();



        VBox left = new VBox(rad, sr, circ, back, circleColor, BackgroundColor);
        HBox xx = new HBox();
        xx.getChildren().addAll(left,right);
        right.getChildren().addAll(colcirc);


        circleColor.setOnAction(e -> colcirc.setFill(circleColor.getValue()));
        colcirc.radiusProperty().bind(sr.valueProperty());
        BackgroundColor.setOnAction(e -> right.setBackground(new Background(
                new BackgroundFill(BackgroundColor.getValue(), null, null))));
        return xx;

    }
}
