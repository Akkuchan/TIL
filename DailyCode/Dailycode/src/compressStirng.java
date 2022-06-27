public class compressStirng {
    public static void main(String[] args) {
        String output = compressString("wwwggoppopppp");
        System.out.println(output);
    }


    public static String compressString(String str) {
        // TODO:
        int a=1;
        String b="";
        String result = "";
        for(int i=1; i<str.length(); i++){
            char k = str.charAt(i);
            if(str.charAt(i-1)== k) {a++; b+=k;}
            else {
                if(a>=3) {result+=Integer.toString(a);}
                else result+=b; result+=k;
            }
            a=1; b="";
        }
        return result;
    }
}
