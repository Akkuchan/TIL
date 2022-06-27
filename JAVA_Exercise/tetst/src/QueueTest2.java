import java.util.*;


public class QueueTest2 {
    public static int queuePrinter(int bufferSize, int capacities, int[] documents) {
        Integer doc[] = Arrays.stream(documents).boxed().toArray(Integer[]::new);
        Queue<Integer> queue = new LinkedList<>(Arrays.asList(doc));// 프린트할 문서들의 크기를 담을 큐
        Queue<Integer> tobeprint = new LinkedList<>();

        int time = 1;

        /*-----------------------------------------------------*/

        tobeprint.add(queue.poll());// 첫값 값 넣고
        int B = queue.poll();
        /*-----------------------------------------------------*/

        while(!tobeprint.isEmpty()) {
            long size = tobeprint.stream().filter(a -> a > 0).count();
            int printcapa = tobeprint.stream().mapToInt(i -> i).sum();
            if (printcapa + B > capacities) //3/ 4 5 6 c:10 b:8 [ | | | | | | | ]
            {
                time += bufferSize - size;// 끝으로 보내기 4초 : [ | | |7] 8초 : [ | | |8]   [ |1|5|4]
                /*-----------------------------------------------------*/
                time++;//끝요소 방출 시간 추가  5초 -  방출 + 영입
                tobeprint.add(B);// [8| | |7]  [9| | |8]  [7| |1|5]
                tobeprint.poll();// 끝요소 방출 [8| | | ]  [9| | | ]  [4 | | | ]
                /*-----------------------------------------------------*/
                if(queue.size()!=0) {B = queue.poll();tobeprint.add(B);}
//                int lastprintcapa2 = tobeprint.stream().mapToInt(i -> i).sum();
                else { time+=bufferSize+1; break;}

                }


             else {
                ++time; //6초
                B = queue.poll();
                tobeprint.add(B); // [ 5|4| | ]   [1|5|4| ]
                B = queue.poll();
            }// 캐파를 안 넘으면 넘을 떄까지 값 받기
//            if(queue.size()==0) {time+=+bufferSize; break;}
        }

        return time;
    }
}
