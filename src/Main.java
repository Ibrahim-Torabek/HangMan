import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

import java.util.Scanner;

public class Main extends Application {
    public static void main(String[] args) {

        Scanner s = new Scanner(System.in);
        char userInput = 'n';


        do {
            int guess = 0;


            for(int i = 0; i < WordTopics.getTopics().length; i++){
                System.out.println(String.valueOf(i +1) + ") " + WordTopics.topics[i][0]);
            }
            System.out.print("Please  select a topic to guess;");


            HangMan hangMan = new HangMan(WordTopics.wordSelect(s.nextInt() - 1));
            s.nextLine();

            do{
                System.out.print("(Guess) Enter a letter in word " + String.valueOf(hangMan.getUserWord()) + " > ");
                userInput = s.nextLine().toCharArray()[0];

                guess = hangMan.checkWord(userInput);

                switch (guess){
                    case HangMan.GUESSED_CORRECT:
                        System.out.println("You guessed a letter: " + userInput);
                        break;

                    case HangMan.GUESSED_WRONG:
                        System.out.println(userInput + " is not in the word.");
                        break;

                    case HangMan.GUESSED_ALREADY_EXIST:
                        System.out.println(userInput + " is already in the word");
                }

            } while (hangMan.getStatus());

            System.out.println();
            System.out.println("The word is \"" + String.valueOf(hangMan.getSelectedWord()) + "\". You missed " + hangMan.getMissed() + " times.");


            System.out.print("Do you want to guess another word? Enter y to play again > ");
            userInput = s.nextLine().toCharArray()[0];

        } while (userInput == 'y');

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
