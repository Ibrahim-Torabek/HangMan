import java.lang.reflect.Array;
import java.util.Random;

public class WordTopics {
    public static String[][] topics = {
            {"Computer Words", "program","java", "array", "string", "class", "computer",  "android", "microsoft"},
            {"General Words","hello", "good","chapter", "book","apple","banana"},
            {"Manga Characters", "naruto","sasukei","hinata","neji","kakashi"}
    };


    /**
     * Randomly select a string from string array, and return it
     * @param topic a user selected topic
     * @return return the string as a char array
     */
    public static char[] wordSelect(int topic){

        Random r = new Random();

        return topics[topic][r.nextInt(topics[topic].length)].toCharArray();
    }

    public static String[] getTopics(){
        int length = WordTopics.topics.length;
        String topics[] = new String[length];

        for(int i = 0; i < length; i++)
            topics[i] = WordTopics.topics[i][0];

        return topics;

    }
    public static void printWord(){
        System.out.println(topics[1][0] + String.valueOf(topics.length));
    }
}
