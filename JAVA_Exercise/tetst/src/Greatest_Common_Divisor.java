import java.util.*;

public class Greatest_Common_Divisor {
    public static void main(String[] args) {
        int M = 4;
        int N = 8;
        ArrayList<Integer[]> output = divideChocolateStick(M, N);
        System.out.println(output);
    }


    public static ArrayList<Integer[]> divideChocolateStick(int M, int N) {
        ArrayList<Integer[]> output = new ArrayList<Integer[]>();
        int employee = gdc(M,N);// 최대공약수=직원수

        for(int i = 1;i<=employee; i++){
            int[] X = new int[3];
            if(M%i==0 && N%i==0) {
                X[0] = i;
                X[1] = M/i;
                X[2] = N/i;
                Integer X2[] = Arrays.stream(X).boxed().toArray(Integer[]::new);//int배열을 Integer[]로
                output.add(X2);
            }
        }
        return output;

    }
   public static int gdc(int M, int N) {
       int tmp, n;
       if (M < N) {
           tmp = M;
           M = N;
           N = tmp;
       }

       while (N != 0) {

           n = M % N;
           M = N;
           N = n;
       }
       return M;
   }













}
