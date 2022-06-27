import java.util.*;

public class Number_four {
    public static String firstCharacter(String str) {
        // TODO:
        if(str.isEmpty()) return "";
        String[] strArr = str.split(" ");
//        list<String> words = new Arraylist<>(Arrays.asList(strArr));
        Queue<String> wordsqueue = new LinkedList<>(Arrays.asList(strArr));
        String output = "";
        while(!wordsqueue.isEmpty()) {
            output += wordsqueue.poll().charAt(0);
        }

        return output;
    }
}