import java.util.*;

public class List_Insteadof_Queue {

    public static int paveBox(Integer[] boxes) {
        List<Integer> leftPeople = new ArrayList<>();
        Integer count = 1;
        int temp = boxes[0];
        for (int i = 1; i < boxes.length; i++) {
            if (temp >= boxes[i]) {//첫 박스 갯수와 다음 박스 갯수를 비교
                count++;
            } else {
                temp = boxes[i];//
                leftPeople.add(count);
                count = 1;
            }
        }
        return Collections.max(leftPeople) ;
    }
}