import java.util.*;

public class greedy1 {
    public static void main(String[] args) {
        int output = movingStuff(new int[]{42, 25, 60, 73, 103, 167}, 187);
        System.out.println(output);
    }


    public static int movingStuff(int[] stuff, int limit) {
        // TODO:

        //짐들의 크기를 정렬(오름차순)
        Arrays.sort(stuff);
        // 0번과 1번의 합이 limit보다 작다면 두 짐을 1개 박스에 담을 것이기에 +1
        // 한 상자에 담긴 짐들은 치워야 하므로 인덱스 +1 처리
        int box=0;
        int min_boxindex=0;


        for(int i=stuff.length-1; i>min_boxindex; i--){ //01234(5개)
            int boxweight=stuff[min_boxindex];
            if(boxweight+stuff[i]<=limit) {
                min_boxindex++;
                box++;

            }
            else {
                box++;
            }


        }
        if(min_boxindex+1==stuff.length/2) return box+1;
        else return box;
    }
}