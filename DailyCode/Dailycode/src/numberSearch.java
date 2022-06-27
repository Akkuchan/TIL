public class numberSearch {


    public static void main(String[] args) {
        int output = numberSearch("Hello6");
        System.out.println(output);
    }

    public static int numberSearch(String str) {
        // TODO:

        if(str.length()==0) return 0;
        double a = 0;
        int b = str.indexOf(0);
        String str1 = str.replaceAll(" ","");
        String str2 = str.replaceAll("[^0-9]+", "");
        for(int i=0; i<str2.length(); i++) {
            char v = str2.charAt(i);
            a+= Integer.parseInt(String.valueOf(v));
        }
        double k = (a/(str1.length()-str2.length()));
        return (int)Math.ceil(k);
    }
}
