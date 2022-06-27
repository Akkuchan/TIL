import java.util.*;

//public class BlackJackCardGame {
//    public static void main(String[] args) {
//        int output = boringBlackjack(new int[]{2,3,4,8,13});
//        System.out.println(output);


//
//
//
//
//
//
//
//    public int boringBlackjack(int[] cards) {
//        // TODO:
//
//        //3값을 더한 거시 소수인 경우의 수를 반환해라
//        ArrayList<int[]> result = new ArrayList<>();
//
//        ArrayList<Integer> availablecard = new ArrayList<>();
//        for(int a: cards) {
//            availablecard.add(a);
//        }
//        boolean[] counted = new boolean[cards.length];
////        System.out.println(permutation(new int[]{}, availablecard, 3, result, counted));
//
////        return permutation3(new int[]{}, availablecard, 3, result, counted);
//
//
//
//    }
//
//
////    public static int  isPrime4(ArrayList<int[]> result){
////        int[] sum = new int[]{};
////        int sum2 = 0;
////        int sumresult =123213;
////        for(int i=0; i<result.size(); i++) {
////            sum = result.get(i);
////            for (int a : sum) {
////                sum2+=a;
////
////                if( sum2 == 1 ) {}
////                else if( sum2 == 2 ) {}
////                else if( sum2 % 2 == 0 ) {}
////
////                int count = 0;
////                for(int i = 3; i <= Math.sqrt(sum2); i += 2){
////                    if( sum2 % i == 0 ){
////                        count++;
////                        // break를 걸거나, return false로 빠져나와도 된다.
////                    }
////                }
////                if(count == 0)
////                    return sumresult=count;
////
////
////        }
////
////            return sumresult;
////    }
//
//
//
//    public  ArrayList<int[]> permutation3(int[] Threecardbox, ArrayList<Integer>availablecard, int howmanycard, ArrayList<int[]> result, boolean[] counted ){
//        if(howmanycard==0){
//            result.add(Threecardbox);// 이전 for문 마지막 부분에서 재료들을 담은 Array를 만들어야 한다.
//            return result;
//
//        }
//        for(int i=0; i<availablecard.size();i++){
//            if(!counted[i]) {
//
//            counted[i] = true;
//            int[] concatArray = Arrays.copyOf(Threecardbox, Threecardbox.length + 1);
//            concatArray[concatArray.length - 1] = availablecard.get(i);
//
//            result = BlackJackCardGame.permutation3(concatArray, availablecard,howmanycard-1,result,counted);
//            counted[i] = false;
//            }
//
//        }
//
//
//
//
//        return result;
//    }
//}
//
//
//





