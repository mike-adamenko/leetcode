import java.util.stream.IntStream;

/**
 *find which season has the biggest temperature amplitude. Input par is the int array with temperatures:

 int T[]= {-1,-10,10,5,30,15,20,-10,30,10,29,20}
 which means:

 winter: -1,-10,10 spring: 5,30,15 summer: 20,-10,30 autumn: 10,29,20
 temp is always an int,
 int[] T - T.length%4 is equal to 0 (same number of temperatures for every season, could be 2, 3 etc.)
 */
public class FindMaxAmplitude {
    public static void main(String[] args) {
        int[] temps = {-3, -14, -5, 7, 8, 42, 8, 3};
        System.out.println(FindMaxAmplitude.solution(temps));
    }

    public static String solution(int[] T) {
        final int count = T.length / 4;
        int indx = 0;
        int last = Integer.MIN_VALUE;
        for (int i = 0; i < 4; ++i) {
            IntStream season = IntStream.of(T).skip(count * i).limit(count);
            int diff = season.max().getAsInt()
                    - season.min().getAsInt();
            if (diff > last) {
                indx = i;
                last = diff;
            }
        }
        final String[] seasons = { "WINTER", "SPRING", "SUMMER", "AUTUMN" };
        return seasons[indx];
    }
}
