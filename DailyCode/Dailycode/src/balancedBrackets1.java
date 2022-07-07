public class balancedBrackets1 {

    public static void main(String[] args) {
        boolean output = balancedBrackets("[](){}");
        System.out.println(output);
    }




    public static boolean balancedBrackets(String str) {
        // TODO:
        int a =0;
        String[] Brakets= new String[]{"[", "]","(",")","{","}"};

            for(int j=0;j<Brakets.length; j++){
                if(str.contains(Brakets[j])) a++;
            }

        if(a==6) return true;
        else return false;
    }








}
