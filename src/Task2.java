import javafx.application.Application;
import javafx.application.Platform;
import javafx.scene.Group;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextInputDialog;
import javafx.geometry.Insets;

import java.io.File;
import java.io.IOException;
import java.util.Optional;

public class Task2 extends Application {
    Button pusher = new Button("выбрать фото");
    Label name = new Label();
    ImageView picture = new ImageView();

    public static void main(String[] args) {

        Application.launch(args);
    }

    @Override
    public void start(Stage stage) {

        FileChooser fileChooser = new FileChooser();

        pusher.setOnAction(e -> {
            File selectedFile = fileChooser.showOpenDialog(stage);
            name.setText(selectedFile.getAbsolutePath());

        });

        Group root = new Group(pusher, name, picture);
        name.setStyle("-fx-padding: 30px");
        stage.setScene(new Scene(root, 400, 650));
        stage.setTitle("ImageChoose");
        stage.setResizable(false);
        stage.show();

    }
}



