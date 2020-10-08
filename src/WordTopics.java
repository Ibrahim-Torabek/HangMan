import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class WordTopics {
//    public static String[][] topics = {
//            {"Computer Words", "program","java", "array", "string", "class", "computer",  "android", "microsoft"},
//            {"General Words","hello", "good","chapter", "book","apple","banana"},
//            {"Manga Characters", "naruto","sasukei","hinata","neji","kakashi"}
//    };

    private ArrayList<List<String>> topics = new ArrayList<>();

    public WordTopics() {


        int i =1;  // To check the file name
        do{
            ArrayList<String> topic = new ArrayList<>();  // Save each topic as an ArrayList
            String fileName = i + ".txt";
            File file = new File(fileName);

            try {
                Scanner fileScanner = new Scanner(file);

                while (fileScanner.hasNextLine()){
                    topic.add(fileScanner.nextLine());
                }
            } catch (FileNotFoundException e) {
                //e.printStackTrace();

                // If file doesn't exist, quit the loop
                break;
            }

            topics.add(topic);  // Add read topic to the topics list.
            i++;
        } while (true);  // loop the read file scope until file does not exist.

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

    public  int getTopicAmount(){
        return topics.size();
    }

    public String getTopic(int topic){
        return topics.get(topic).get(0);
    }

}
