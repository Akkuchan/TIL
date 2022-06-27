public class readVirtically {

    public static void main(String[] args) {
        String[] input = new String[]{
                "hi",
                "wolrd"
        };
        String output = readVertically(input);
        System.out.println(output);



    }


    public static String readVertically(String[] arr) {
        // TODO:
        String result = "";
        String biggest = arr[0];
        for(int b=0; b<arr.length; b++){
            if(arr[b].length()>biggest.length()) {
                biggest=arr[b];
            }
        }
        for(int c=0; c<arr.length; c++){
            while(arr[c].length()<biggest.length()) {
                arr[c] += " ";
            }

        }

            for (int i = 0; i < biggest.length(); i++) {
                for (int j = 0; j < arr.length; j++) {
                    result += arr[j].charAt(i);  // 00 10 01 11
                }
            }

        return result.replaceAll(" ","");
    }








}
