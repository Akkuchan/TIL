import java.util.*;



public class ChickenSource {

    public static void main(String[] args) {
        ArrayList<Integer[]> output1 = newChickenRecipe(new int[]{1, 10, 1100, 1111}, 2);
        System.out.println(output1);
    }




    public static ArrayList<Integer[]> newChickenRecipe(int[] stuffArr, int choiceNum) {
        // TODO:
        ArrayList<Integer[]> result = new ArrayList<Integer[]>();// String[]를 담을 리스트
        //상한 재료는 제거, 신선재료만 따로 담기(freshIng)
        ArrayList<Integer> freshIng= new ArrayList<Integer>();

        for(int i=0; i<stuffArr.length; i++){
            int zerocnt = 0;
            String strIng = Integer.toString(stuffArr[i]);// int타입의 재료를 String으로 변환
            for(int j=0; j<strIng.length(); j++){
                if(strIng.charAt(j)=='0'){
                    zerocnt++;
                }
            }
            if(zerocnt<3) {
                freshIng.add(stuffArr[i]);
            }
        }
        boolean[] visited = new boolean[freshIng.size()];
        // 재귀를 돌면서 최종에 list(n)을 담을 result
        // 재귀를 몇번돌지 choiceNum
        // 요소들을 담은 배열
        Collections.sort(freshIng);
        if (freshIng.size() == 0 || freshIng.size() < choiceNum) return null;
        return HowManySourceCouldBe(new Integer[]{},freshIng, choiceNum, result,visited );
    }
    // 0이 3개이상일 때는 해당 배열 제외
    // 예로 [0]을 고르고 [0제외 1,2,3,..n]을 choiceNum만큼 뽑은 요소를 하나의 String[]에 담아야한다.
    // choicdNum의 크기에 따라 배열의 크기가 변할 것이므로 단일 for문에서 배열생성보단
    // 재귀로 int[]를 점차 크기를 갱신하면서 생성하고 마지막 배열을 list에 담는다.

    public static ArrayList<Integer[]> HowManySourceCouldBe(Integer[] freshInglist,ArrayList<Integer> freshIng, int choiceNumCnt, ArrayList<Integer[]> result, boolean[] visited ){
        //재귀 종료문
        if(choiceNumCnt==0){
            result.add(freshIng.toArray(new Integer[0]));// 이전 for문 마지막 부분에서 재료들을 담은 Array를 만들어야 한다.
            return result;
        }
        //Arrays.copyOfRange(원본 배열, 복사할 시작인덱스, 복사할 끝 인덱스)
        for(int i=0; i<freshIng.size(); i++){
            if(!visited[i]) {
                visited[i] = true;
                Integer[] concatArray = Arrays.copyOf(freshInglist, freshInglist.length + 1);
                concatArray[concatArray.length - 1] = freshIng.get(i);


                result = HowManySourceCouldBe(concatArray, freshIng, choiceNumCnt - 1, result, visited);
                visited[i] = false;
            }
        }
        return result;
    }

}














