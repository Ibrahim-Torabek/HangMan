import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

import java.util.Scanner;

public class Main extends Application {
    public static void main(String[] args) {

        Scanner s = new Scanner(System.in);
        char userInput = 'n';



        s.close();
        System.exit(0);

        //Application.launch(args);

    }


    @Override
    public void start(Stage stage) throws Exception {
        BorderPane root = new BorderPane();
        Scene scene = new Scene(root);

        stage.setScene(scene);
        stage.show();
    }
}
