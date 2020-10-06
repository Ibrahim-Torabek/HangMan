import java.util.Random;

public class HangMan {
    private char[] selectedWord; //  = wordSelect();
    private char[] userWord; //= new char[selectedWord.length];
    private int guessed;
    private int missed;

    public HangMan() {
        selectedWord = wordSelect();
        userWord = new char[selectedWord.length];
        guessed = 0;
        missed = 0;

        checkWord('*');
    }

    public char[] wordSelect(){
        String[] words = {"hello", "good", "program","oolllpp","java",
                "array", "string", "class", "chapter", "book",
                "computer", "apple", "android", "microsoft"};
        Random r = new Random();

        return words[r.nextInt(words.length)].toCharArray();
    }

    public int checkWord(char userInput){
        int remain = 0;

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

                return -1;
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
            return 0;
        }

        guessed = selectedWord.length - remain;

        return 1;
    }

    public boolean getStatus(){
        if (guessed == selectedWord.length)
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
