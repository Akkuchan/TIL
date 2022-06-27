
import java.util.Arrays;
        import java.util.List;
public class ArrayConversion {
    public static void main(String[] args) {
        String[] arr = {"A", "B", "C"};
        // 배열 -> List로 변환
        List<String> list = Arrays.asList(arr);
        System.out.println(list);
        System.out.println(list.get(0)); // "A"
        System.out.println(list.get(1)); // "B"
        System.out.println(list.get(2)); // "C"
    }
}