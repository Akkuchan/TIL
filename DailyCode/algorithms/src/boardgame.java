import java.util.*;
public class boardgame {
    public static void main(String[] args) {
        int[][] board1 = new int[][]{
                {0, 0, 0, 1},
                {1, 1, 1, 0},
                {1, 1, 0, 0},
                {0, 0, 0, 0}
        };
        int output1 = boardGame(board1, "RRDLLD");
        System.out.println(output1);

    }


    public static Integer boardGame(int[][] board, String operation) {
        // TODO:
        Queue<String> move = new LinkedList();
        String[] a = operation.split("");

        for (String s : a) {
            move.offer(s);
        }
        //move = [R, R, D, L, L, D]
        // 현재위치 변수 생성
        int row =0;
        int column =0;
        int output = 0;// 점수를 담을 변수 생성
        int k =0;
        System.out.println(column);

//        while(!move.isEmpty()){
        for(int i=0; i<a.length;i++){

            //이동명령(operation)을 하나씩 반환
            String moving = move.poll();
            System.out.println(moving.toString());
            System.out.println("R");
            //만약 R이면 현재위지에서 [][+1], 해당 위치의 값이 1이면 점수+1
            if(moving.equals("R")) {
                ++column;
            }
            //만약 L이면 현재위치에서 [][-1]
            if(moving.equals("L")) {
                --column;
            }
            //만약 U이면 현재위치에서 [-1][]
            if(moving.equals("U")) {
                --row;
            }
            //만약 D이면 현재위치에서 [+1][]
            if(moving.equals("D")){
                ++row; k++;
            }
            // 이동 후 만약 현재위치가 범위를 벗어나면 RETURN NULL
            if(row<0 || column<0){
                break;
            }
            if(board[row][column]==1) {
                output++;
            }
        }



        if(row<0 || column<0)  return null;
        else return output;
    }



}
