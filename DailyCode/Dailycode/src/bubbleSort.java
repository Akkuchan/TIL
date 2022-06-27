public class bubbleSort {


    public static void main(String[] args) {
        int[] output = bubbleSort(new int[]{5,4,3,2,1});
        System.out.println(output);
    }










    public static int[] bubbleSort(int[] arr) {
        // TODO:

        int pair=0;
//        for(int i=arr.length; i>0; i--){
        for(int i=0; i<arr.length-1; i++){
            int a=0;
//            for(int j=1; j<i; j++){
            for(int j=0; j<arr.length-i-1; j++){
                if(arr[j]>arr[j+1]) {
                    pair=arr[j+1];
                    arr[j+1]=arr[j];
                    arr[j]=pair;
                    a++;
                }
            }
            if(a==0) break;
        }
        return arr;
    }
}
