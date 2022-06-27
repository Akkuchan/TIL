import java.util.*;
public class greedy2 {
    public static void main(String[] args) {
        int output1 = partTimeJob(4972);
        System.out.println(output1);
    }
    public static int partTimeJob(int k) {
        // TODO:
        int coincount =0;
        int output =k;//코인 개수를 더해줄 변수 & k를 줄여나갈 변수
        int[] coin = {500, 100, 50, 10, 5, 1};
        Queue<Integer> coins = new LinkedList();
        for(int a:coin){
            coins.offer(a);
        }
        String operation = "RRDLLD";
        Queue<String> move = new LinkedList();
        String[] a = operation.split("");
        for(int i =0; i<a.length; i++){
            move.offer(a[i]);
        }
        System.out.println(move);


        while(!coins.isEmpty()){

            int nowcoin= coins.poll();
            coincount += output/(int)nowcoin;
            output = k%nowcoin;
            if(output == 0) break;
        }
        return coincount;
    }


}
