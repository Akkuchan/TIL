import java.util.*;
public class Twospacetoonespace {

    public static void main(String[] args) {
        String output = convertDoubleSpaceToSingle("string  with  double  spaces");
        System.out.println(output);
    }




    public static String convertDoubleSpaceToSingle(String str) {
        // TODO:

//        for(int i= 0; i<str.length(); i++){
//            if(str.charAt(i)==" " && str.charAt(i)==str.charAt(i+1)){
//
//
//            }
//
//        }
        String str2=str.replace("  "," ");
        return str2;
    }
}
