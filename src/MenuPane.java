import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;

import java.awt.event.MouseListener;
import java.util.ArrayList;

public class MenuPane extends VBox {
    public MenuPane() {
        ArrayList<Button> topicButtons = new ArrayList<>();

        String selectedTopic;

        for(int i = 0; i < Main.wordTopics.getTopicAmount(); i++){
            Button topic = new Button(Main.wordTopics.getTopic(i));
            topic.setMaxHeight(20);
            topic.setMaxWidth(300);
            topic.setFont(Font.font(20));
            int finalI = i;
            topic.setOnMousePressed(e -> {
                char[] selected = Main.wordTopics.wordSelect(finalI);
                Main.hangMan = new HangMan(selected);
                Main.mainStage.setScene(new GameScene(new GamePane()));
            });
            topicButtons.add(topic);
            this.getChildren().add(topic);

        }
        this.setAlignment(Pos.CENTER);
        this.setSpacing(20);
    }

}
