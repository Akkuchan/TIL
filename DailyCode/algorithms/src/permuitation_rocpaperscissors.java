import java.util.*;

public class permuitation_rocpaperscissors {
    public static void main(String[] args) {
        ArrayList<String[]> output = rockPaperScissors(5);

        System.out.println(output);
    }

    public static ArrayList<String[]> rockPaperScissors(int rounds) {
        ArrayList<String[]> outcomes = new ArrayList<>();// 결과를 반환할 ArrayList
        return permutation(rounds, new String[]{}, outcomes);
    }
    //roundsToGo: 라운드가 점차줄어들면서 진행할 라운드의 횟수 ,
    public static ArrayList<String[]> permutation(int roundsToGo, String[] playedSoFar, ArrayList<String[]> outcomes) {
        if(roundsToGo == 0) {// 더이상 남은 라운드가 없다면
            outcomes.add(playedSoFar);// 지금까지한 작업들을 결과에 넣는다.
            return outcomes;
        }
        String[] rps = new String[]{"rock", "paper", "scissors"};

        for(int i = 0; i < rps.length; i++) {//i가 0일 때
            String currentPlay = rps[i];//rps는 "rock"
            String[] concatArray = Arrays.copyOf(playedSoFar, playedSoFar.length + 1);
            concatArray[concatArray.length - 1] = currentPlay;
            outcomes = permutation(roundsToGo - 1, concatArray, outcomes);
        }
        return outcomes;
    }
}
