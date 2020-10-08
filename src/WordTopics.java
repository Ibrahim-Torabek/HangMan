import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class WordTopics {
//    public static String[][] topics = {
//            {"Computer Words", "program","java", "array", "string", "class", "computer",  "android", "microsoft"},
//            {"General Words","hello", "good","chapter", "book","apple","banana"},
//            {"Manga Characters", "naruto","sasukei","hinata","neji","kakashi"}
//    };

    private ArrayList<List<String>> topics = new ArrayList<>();

    public WordTopics() {
        ArrayList<String> topic = new ArrayList<>();

        topic.add("Computer Words");
        topic.add("java");
        topic.add("android");
        topic.add("swift");
        topics.add(topic);
        topic.add("General Words");
        topic.add("hello");
        topic.add("good");
        topic.add("morning");
        topics.add(topic);

    }

    /**
     * Randomly select a string from string array, and return it
     * @param topic a user selected topic
     * @return return the string as a char array
     */
    public char[] wordSelect(int topic){
        Random r = new Random();

        return topics.get(topic).get(r.nextInt(3) + 1).toCharArray();
    }

    public String[] getTopics(){
        int length = this.topics.size();
        String topics[] = new String[length];

        for(int i = 0; i < length; i++)
            topics[i] = this.topics.get(i).get(0);

        return topics;

    }

}
