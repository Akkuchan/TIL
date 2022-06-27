import java.util.*;

public class graph {


    public static boolean getDirections(int[][] matrix, int from, int to) {
        // TODO:

        List<Integer> visitedList = new ArrayList<Integer>();
        Queue<Integer> queue = new LinkedList<>();//0번째 행부터 테스트
        for (int j = 0; j < matrix.length; j++){
            visitedList.add(j);
        }


        queue.add(from);//0번째 행부터 테스트
        visitedList.set(from, 1);

        while(queue.size()>0){ // 큐가 없어질 때까지 실행
          int current = queue.poll();// 시작지점 from부터 담긴 큐에서 하나씩 체크
          if(current== to) return true;// 해당지점(from)이 목표 지점 to와 같은가

          for(int i =0; i<matrix[current].length; i++){// 각 행의 하위 배열 순환
              if(matrix[current][i] ==1 && visitedList.get(i)==0){//하위 배열값이 1 and
                  visitedList.set(i, 1);
                  queue.add(i);

              }

          }

        }
        return false;
    }
}