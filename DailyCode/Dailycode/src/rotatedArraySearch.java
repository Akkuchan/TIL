public class rotatedArraySearch {

    public static void main(String[] args) {
        int output = rotatedArraySearch(new int[]{4, 5, 6, 0, 1, 2, 3}, 2);
        System.out.println(output);
    }








    public int rotatedArraySearch(int[] rotated, int target) {
        // TODO:


//        if(Arrays.stream(rotated).anyMatch(s -> s.equals(target))) return rotated.indexOf(target);
        if(Arrays.asList(rotated).contains(target)) return rotated.indexOf(target);
        else return -1;
    }
}
