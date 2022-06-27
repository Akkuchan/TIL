import java.util.*;


public class QueueTest {
    public static int paveBox(Integer[] boxes) {
        // TODO:
        // 5,4,3,2,1, 7,6,5,4,3,2,1, 4,3,2,1, 5,4,3,2,1, 7,5,4,3,2,1, 4,3,2,1, 5,4,3,2,1

            // 들어가는 순서대로 한명씩 나가야 한다(queue) -> queue에 boxes의 값들을 담는다.

            Queue<Integer> listqueue = new LinkedList<Integer>(Arrays.asList(boxes));// 리스트인덱스 생성자의 파라미터는 배열X, 리스트가 와야한다.
            List<Integer> countlist = new ArrayList<Integer>();//count 값들을 담아 후에 최대 값을 반환할 값들의 모음

            // 뒷사람이 포장을 전부 끝냈어도 앞 사람이 끝나야만 나갈 수 있다.
            //  -> 1 2 3 4 순서대로 순환하면서 제일 큰 값을 넣어준다, 더 큰 값이 뒤에 나오면 제일 큰 값을 바꿔주고 해당 값의 인덱스 이전의 요소들을 count, 카운드한 값을 배열에 넣기
            // 카운트한 값들중 제일 큰 값 찾기(최대 몇명이 한번에 나가는지)
            int count=1;

            int max = 0;

            while(!listqueue.isEmpty()){
                int nextone = listqueue.poll();

                if(max<nextone) { countlist.add(count); max = nextone; count=1; }
                else count++;
                if(listqueue.isEmpty()) { countlist.add(count);break;}
            }
            return Collections.max(countlist);

//        Queue<Integer> queue = new LinkedList<>(Arrays.asList(boxes));
//        int outmen = 1;//앞의 인원 박스 끝날 때까지 기다렸다가 같이 나갈 인원
//        int biggest = queue.poll();//첫 박스의 갯수이자 가장 큰 박스 갯수
//        while (!queue.isEmpty()) {
//            int nextone = queue.poll();// biggest와 비교할 뒷 사람
//            if (biggest >= nextone) ++outmen;//뒷 사람은 대기인원에 +
//            else {//더 큰 박스가 나타났을 때
//                if (queue.isEmpty()) break;//그 박스 뒤에 인원 없을 때(poll(삭제)했으니 끝)
//                else { biggest = nextone; outmen = 1;//더 큰 박스 갯수로 biggest 갱신, 대기 인원은 초기화
//                }
//            }
//        }
//        return outmen;
    }
}






















//    // 인덱스 0인 사람의 박스가 뒤의 N번째까지의 사람들 보다  많다면 최대값은 N+1 이를 셀 변수가 필요
//    // 0~n, m~M+B 의 인원 중 전자가 더 크다면 그 값을 반환해야함 그러면 이 인원수를 담을 컬렉션이 필요// 타입은 int
//    List<Integer> leftPeople = new ArrayList<Integer>();// 중복은 의미가 없기에 Set으로 설정; int인데 Integer로 해도 되나?
//    int count = 0;
//        Loop1:
//                for(int i=0; i<boxes.length-1;i++) {
//
//        Loop2: for (int j = i+1; i < boxes.length; j++) {
//        if (boxes[i] >= boxes[j]) //  01 02  03 04 /12 13 14.../23 24 25...
//        {++count; continue;}
//        else {i=j; leftPeople.add(count); count = 0;}
//        }
//
//        }
//        return Collections.max(leftPeople)+1;
////        Collections.max(leftPeople)+1;