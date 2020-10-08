
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.Text;


public class EndPane extends VBox {
    public EndPane() {
        Text resultText = new Text("Result: ");

        if(Main.hangMan.getMissed() >= 6){
            resultText.setText("You Missed.\n It is '" + Main.hangMan.getSelectedWord() + "'");
        } else {
            resultText.setText("You Won!!!");
        }

        resultText.setFont(Font.font("Times New Roman", 100));

        Button endButton = new Button("Go to Main Menu");
        endButton.setFont(Font.font(50));
        endButton.setOnMouseClicked(e -> {
            Main.mainStage.setScene(new MenuScene(new MenuPane()));
        });

        this.setAlignment(Pos.CENTER);
        this.getChildren().addAll(resultText,endButton);
    }
}
