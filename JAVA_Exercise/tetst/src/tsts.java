
import java.util.*;
public class tsts {
    public static void main(String[] args) {
        String[] actions = {"B", "C", "-1", "D", "A", "-1", "1", "-1", "-1"};
        String start = "A";
        ArrayList<Stack> output = StackTest.browserStack(actions, start);

        System.out.println(output);
    }


}