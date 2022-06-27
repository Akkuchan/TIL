public class computerSquereRoot {

        public static void main(String[] args) {
            String output = computeSquareRoot(7);
            System.out.println(output);
        }


        public static String computeSquareRoot(int num) {
            // TODO:
            double a = 1;
            for(int i=0; i<num; i++) {

                a= 0.5*(a+(num/a));

            }
            String result = String.format("%.2f", a);
            return result;
        }
}


