import java.util.*;

public class RockPaperScissors {

    public static void main(String[] args) {
        ArrayList<String[]> output = rockPaperScissors(5);

        System.out.println(output);
    }








    public static ArrayList<String[]> rockPaperScissors(int rounds) {
        // TODO:
        ArrayList<String[]> RPSlist = new ArrayList<>();
        String[] newSarray =  new String[]{};
        return permutation1(rounds, newSarray, RPSlist);
    }

    public static ArrayList<String[]> permutation1(int rounds, String[] newSarray, ArrayList<String[]> RPSlist){

        if(rounds == 0) {
            RPSlist.add(newSarray);
            //지금까지 작성한 String 배열(맨처음이면, ["rock", "rock", "rock", "rock", "rock"]을 RPClist의 첫 값으로)을
            // 넣어주어 ArrayList 요소를 하나씩 채운다. 맨 마지막 for문에서는 마지막 값이 "rock", "paper", "scissors"로 돌아가면 삽입될 것이고
            // 이 3번이 끝나면 그 이전 for문에서 String[0]이 String[1]로 바뀌고 또 다시 마지막 for문이 돌면서
            // 마지막-1 인덱스 값이 paper로 바뀐 채로 마지막 인덱스 값이 "rock", "paper", "scissors"로 돌아가면서 넣어진 배열이 또 다시 ArrayList 요소로
            // add 될 것.때문에 마지막 재귀종료 if문에서 ArrayList<String[]타입의 RPClist를 리턴해야한다
            return RPSlist;
        }


        String[] RPC = {"rock", "paper", "scissors"};

        for(int i=0; i<RPC.length; i++){
            //만약 rounds만큼 순환한다면 String을 담을 배열의 크기를 rounds로 생성해야 하고 그러면
            // [0], [0][1], [0][1][2] ... 이렇게 해당 인덱스 값을 각각의 for문으로 대입하고(rounds 개수 만큼의 for문 사용)
            // 각각의 for문에서 RPC.length만큼 순환할 for문을 하나씩 또 추가해주어서 r,p,c를 넣어주어야한다.
            // ex.for(rounds번 반복){	for(RPC.length반복){}	}*
            String myturn = RPC[i];

            String[] concatArray = Arrays.copyOf(newSarray, newSarray.length + 1);
            // 재귀돌 때 앞에서 전달받은 String배열에서 값은 그대로 둔채
            // 배열 크기를 1칸 늘려 다음 String 요소를 추가할 수 있도록 +1크기의 배열 새로 생성
            // 배열을 크기 변동이 불가하기에 복사& +1크기 배열 새로 만들고 & 그 안에 복사한 값넣기
            concatArray[concatArray.length-1] = myturn;
            // 새로만든 배열 마지막에 값을 넣어서 요소를 채운다.

            RPSlist = permutation1(rounds - 1, concatArray, RPSlist);


        }


        return RPSlist;
    }

}
