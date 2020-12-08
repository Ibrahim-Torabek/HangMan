import java.util.Random;

public class HangMan {
    public final static int GUESSED_WRONG = 0;
    public final static int GUESSED_ALREADY_EXIST = -1;
    public final static int GUESSED_CORRECT = 1;

    private char[] selectedWord; //  = wordSelect();
    private char[] userWord; //= new char[selectedWord.length];
    private int guessed;
    private int missed;

    public HangMan(char [] selectedWord) {
        this.selectedWord = selectedWord;
        userWord = new char[this.selectedWord.length];
        guessed = 0;
        missed = 0;

        checkWord('*');
    }


    /**
     * Randomly select a string from string array, and return it
     * @return return the string as a char array
     */
    public char[] wordSelect(){
        String[] words = {"hello", "good", "program","oolllpp","java",
                "array", "string", "class", "chapter", "book",
                "computer", "apple", "android", "microsoft"};
        Random r = new Random();

        return words[r.nextInt(words.length)].toCharArray();
    }

    /**
     * check a given character from a char array, if exit, put it into the userWord array.
     * it will initial the userWord by star(*)s when the third parameter is '*'
     *                 is exist in the first parameter, put that letter into same position in second parameter (userWord).
     * @param userInput receive a letter which is typed by user.
     *                  - if it is '*', this function will initial userWord by '****"
     * @return return guessed status: 1 for guessed, 0 for incorrect and -1 for exist.
     */
    public int checkWord(char userInput){
        int remain = 0;
        userInput = Character.toUpperCase(userInput);

        // Initial
        if (userInput == '*'){

            for(int i = 0; i < userWord.length; i++){
                userWord[i] = '*';
            }

            remain =  userWord.length;
        }

        // Check existence
        for(int i = 0; i < userWord.length; i++){
            if (userWord[i] == userInput) {

                return HangMan.GUESSED_ALREADY_EXIST;
            }
        }

        // Place guessed word
        for(int i = 0; i < userWord.length; i++){
            if(selectedWord[i] == userInput){
                userWord[i] = userInput;
                //guessed++;
            }
        }

        // Figure the remaining words and return it
        for(int i = 0; i < userWord.length; i++) {
            if (userWord[i] == '*')
                remain++;
        }

        if(guessed == selectedWord.length - remain) {
            missed++;
            return HangMan.GUESSED_WRONG;
        }

        guessed = selectedWord.length - remain;

        return HangMan.GUESSED_CORRECT;
    }

    /**
     * Determine if the guessing loop should stop.
     * @return true or false.
     *    Note: This is not a getter method.
     */
    public boolean getStatus(){
        // if guessed all letters, or missed more than 6 times, quit the loop.
        if (guessed == selectedWord.length || missed >=6)
            return false;

        return true;
    }

    public char[] getUserWord() {
        return userWord;
    }

    public String getSelectedWord() {
        return String.valueOf(selectedWord);
    }

    public int getMissed() {
        return missed;
    }
}
