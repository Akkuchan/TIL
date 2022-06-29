import java.util.*;
import java.util.stream.Collectors;

public class isSubsetOf {


    public static void main(String[] args) {
        int[] base = new int[]{1, 2, 3, 4, 5};
        int[] sample = new int[]{1, 3};
        boolean output = isSubsetOf(base, sample);
        System.out.println(output);

    }


    public static boolean isSubsetOf(int[] base, int[] sample) {
        // TODO:

        List<Integer> B = Arrays.stream(base).boxed().collect(Collectors.toList());
        
        for(int i=0; i<sample.length;i++){
            if(B.contains(sample[i])) return false;;
        }
  
         return true;
    }







}
