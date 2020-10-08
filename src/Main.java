import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

import java.util.Scanner;

public class Main extends Application {
    public static void main(String[] args) {


        Scanner s = new Scanner(System.in);
        WordTopics wordTopics = new WordTopics();

        char userInput;


        do {
            int guess;
            HangMan hangMan;

            // Display topics from WordTopics class.
            for(int i = 0; i < WordTopics.getTopics().length; i++){
                System.out.println(String.valueOf(i +1) + ") " + WordTopics.topics[i][0]);
            }
            System.out.print("Please  select a topic to guess;");

            userInput = s.nextLine().toCharArray()[0];

            // Check if the user input is valid.
            // If entered character '1' to the length of the topic is correct.
            if (userInput >= 49 && userInput < 49 + WordTopics.topics.length){
                hangMan = new HangMan(WordTopics.wordSelect(userInput - 49));
            } else {
                // if is not correct, continue the loop.
                System.out.println("Please select a number from 1 to " + WordTopics.topics.length);
                userInput = 'y'; // Because the loop condition is character 'y', set the userInput variable to 'y'
                continue;
            }

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


            System.out.println("\nThe word is \"" + String.valueOf(hangMan.getSelectedWord()) + "\". You missed " + hangMan.getMissed() + " times.");


            System.out.print("Do you want to guess another word? Enter y to play again > ");
            userInput = s.nextLine().toCharArray()[0];

        } while (userInput == 'y');

        s.close();

        // Because the class extended from application class, exit the program manually.
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
