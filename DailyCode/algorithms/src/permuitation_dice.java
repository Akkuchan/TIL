import java.util.*;

public class permuitation_dice {


    public static void main(String[] args) {
        dice1(3);
    }
    static int N,totalCnt;
    static int[] numbers;
    static boolean[] isSelected;

    private static void dice1(int cnt) {
        if(cnt == N) { // 기저 조건
            totalCnt++;
            System.out.println(Arrays.toString(numbers));
            return;
        }
        for(int i =1; i<=6; i++) { // 유도 파트
            numbers[cnt] = i;
            dice1(cnt+1);
        }
    }
}
