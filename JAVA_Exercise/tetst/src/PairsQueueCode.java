import java.util.*;
public class PairsQueueCode {

    public static int paveBox(Integer[] boxes) {
        // TODO:
        Queue<Integer> queue = new LinkedList<>(Arrays.asList(boxes));

        int person = 0;
        int maxTime = 1;
        int maxBox = Integer.MIN_VALUE;//박스의 최대값을 Integer 최대값으로 초기화(-2n31)
        int box = 0;
        while(!queue.isEmpty()){
            box = queue.poll();//앞으로 오는 박스의 값이 계속 담길 예정
            if(box > maxBox){//뒤의 박스가 앞 박스보다 클 때/ 첫 순환시 당연히 true(maxBox는 -2n31, 음수이기에),
                person = 1;
                maxBox = box;
            } else {
                person++;
            }
            if(person > maxTime)// 한번에 가장 많이 나가는 인원 체크 조건문, maxTime에는 최대 인원값이 계속 갱신되며 담김
                maxTime = person;
        }
        return maxTime;
    }
}
