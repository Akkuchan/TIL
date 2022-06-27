import java.util.*;

public class removeExtremes {
    public static void main(String[] args) {
        String[] output = removeExtremes(new String[]{"a", "b", "ddd", "def"});
        System.out.println(output); // --> ["where", "the", "word"]
    }



    public static String[] removeExtremes(String[] arr) {
        // TODO:
        List<String> result = new ArrayList<String>(Arrays.asList(arr));
        String minword= arr[0];
        String maxword= arr[0];

        for(int i=1; i<arr.length; i++){
            if(arr[i].length()<=minword.length()){

                minword=arr[i];
                 }
        }

        for(int i=1; i<arr.length; i++){
            if(arr[i].length()>=maxword.length()){

                maxword=arr[i];
            }
        }

        result.remove(maxword);
        result.remove(minword);
        String[] resultArray = result.toArray(new String[0]);
        return resultArray;
    }




}
