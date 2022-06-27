import java.util.*;

public class convertlilst_TO_object {
    public static void main(String[] args) {
        String[][] arr = new String[][]{
                {},

        };

        HashMap<String, String> output = convertListToHashMap(arr);
        System.out.println(output);
    }


    public static HashMap<String, String> convertListToHashMap(String[][] arr) {
        // TODO:
        HashMap<String, String> newhash = new HashMap<String, String>();

        for(int i=0; i<arr.length; i++){
            if(arr[i].length==0) break;
            if(newhash.containsKey(arr[i][0])){ continue; }
            for(int j=0; j<arr[i].length;j++ ){

                newhash.put(arr[i][0],arr[i][j] );

            }
        }



        return newhash;
    }





}
