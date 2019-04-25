import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * Should return in the following order:
 * g1 act car
 * a8 act zoo
 * ab1 off key dog
 * a1 9 2 3 1
 * zo4 4 7
 */
public class ReorderLines {
    public static void main(String[] args) {
        List<String> logLines = Arrays.asList("a1 9 2 3 1", "g1 act car", "zo4 4 7", "ab1 off key dog", "a8 act zoo");
        new ReorderLines().reorderLines(5, logLines).forEach(System.out::println);
    }

    public List<String> reorderLines(int logSize, List<String> logLines) {
        logLines.sort((o1, o2) -> {
            String str1 = o1.substring(o1.indexOf(" ")+1, o1.length());
            String str2 = o2.substring(o2.indexOf(" ")+1, o2.length());
            if (str1.matches("[\\d ]+"))return 1;
            if (str2.matches("[\\d ]+"))return -1;
            return str1.compareTo(str2);
        });
        return logLines;
    }
}
