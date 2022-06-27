public class ABCheck {




    public boolean ABCheck(String str) {
        // TODO:
        boolean result=false;
        for(int i=4; i<str.length(); i++){
            char A =  Character.toUpperCase(str.charAt(i-4));
            char B =  Character.toUpperCase(str.charAt(i));
            if(A=='A' && B=='B') result = true;
            if(A=='B'&& B=='A') result = true;
        }
        return result;
    }





}
