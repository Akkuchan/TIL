public class largestProductOfThree {
    public static void main(String[] args) {
        int output = largestProductOfThree(new int[]{-1, 2, -5, 7});
        System.out.println(output);
    }

    public static int largestProductOfThree(int[] arr) {
        // TODO:
        for(int k=0; k<arr.length; k++){
            if(arr[k]<0) arr[k]*=-1;
        }

        for(int i=0; i<arr.length; i++){
            for(int j=i+1; j<arr.length; j++){
                if(arr[i]<arr[j]){
                    int pair = arr[i];
                    arr[i]=arr[j];
                    arr[j]=pair;
                }
            }
        }
        return arr[0]*arr[1]*arr[2];
    }
}
