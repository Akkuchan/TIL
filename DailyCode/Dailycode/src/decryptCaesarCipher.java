public class decryptCaesarCipher {


    public static void main(String[] args) {
        String output = decryptCaesarCipher("nzopdelepd", 11);
        System.out.println(output);
    }



    public static String decryptCaesarCipher(String str, int secret) {
        // TODO:
        if(str.length()==0) return "";
        String result = "";
        int bulk = 0;

        for(int i=0; i<str.length(); i++){
            if(str.charAt(i)==' ') {result+= " "; continue;}
            else if(str.charAt(i)+secret*-1<97){ bulk= str.charAt(i)+secret*-1+26;}
            else bulk= str.charAt(i)+secret*-1;
            result+= Character.toString((char)bulk);
        }

        return result;
    }

}








