import java.util.*;
public class Capitalize {
    public static void main(String[] args) {
        String output1 = letterCapitalize("");
        System.out.println(output1);
    }







    public static String letterCapitalize(String str) {
        // TODO:
        String[] words = str.split(" ");

        String newstr = "";
        for(String A : words){
            if(A.isEmpty()){ A="  ";}
            else newstr += A.substring(0, 1).toUpperCase() + A.substring(1) + " ";

        }



        return newstr.substring(0,newstr.length()-1);
    }
}

