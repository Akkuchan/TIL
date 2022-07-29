import java.util.stream.Stream;

public class test {
    public static void main(String[] args) {
        Stream.of("a","b","c","","e","f").takeWhile(s->!s.isEmpty());
    }
}
