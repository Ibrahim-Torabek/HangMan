import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.layout.*;
import javafx.scene.text.Font;
import javafx.scene.text.Text;

import java.util.ArrayList;

public class GamePane extends BorderPane {
    public GamePane() {
        System.out.println(Main.wordTopics.getSelectedTopic());

        HangPane hangPane = new HangPane();
        this.setLeft(hangPane);

        ArrayList<Button> letters = new ArrayList<>();
        VBox rightSide = new VBox();

        GridPane buttonsGrid = new GridPane();

        Text userWord = new Text();
        userWord.setFont(Font.font(200));
        Text incorrectLetters = new Text("Incorrect Letters: ");
        incorrectLetters.setFont(Font.font(50));
        userWord = new Text(String.valueOf(Main.hangMan.getUserWord()));

        for(char ch = 'A'; ch <= 'Z'; ch++){
            Button letter = new Button(String.valueOf(ch));
            letter.setFont(Font.font(30));
            char finalCh = ch;
            Text finalUserWord = userWord;
            letter.setOnMousePressed(e -> {
                int guess = Main.hangMan.checkWord(finalCh);
                switch (guess){
                    case HangMan.GUESSED_ALREADY_EXIST:
                        break;

                    case HangMan.GUESSED_CORRECT:
                        finalUserWord.setText(String.valueOf(Main.hangMan.getUserWord()));
                        break;

                    case HangMan.GUESSED_WRONG:
                        incorrectLetters.setText(incorrectLetters.getText() + String.valueOf(finalCh));
                        hangPane.hang(Main.hangMan.getMissed() - 1);
                        break;
                }

                letter.setDisable(true);
                if(!Main.hangMan.getStatus()){
                    Main.mainStage.setScene(new EndScene(new EndPane()));
                }

            });
            letters.add(letter);
            letter.setMaxWidth(70);

            buttonsGrid.add(letter,(ch - 'A') % 6,Math.round((ch - 'A') / 6));
            //System.out.println();
        }

        userWord.setFont(Font.font(50));
        buttonsGrid.setVgap(20);
        buttonsGrid.setHgap(20);
        buttonsGrid.setPadding(new Insets(20));
        rightSide.getChildren().addAll(userWord,buttonsGrid);

        this.setTop(incorrectLetters);
        this.setRight(rightSide);
        this.setAlignment(rightSide,Pos.CENTER);
    }
}
