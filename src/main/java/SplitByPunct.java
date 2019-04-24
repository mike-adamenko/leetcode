/**
 *
 */
public class SplitByPunct {
    public static void main(String[] args) {
        String test = "fsdf,, sdfsdf'f sdfsd!";
        //by punct and space
        //https://www.regular-expressions.info/posixbrackets.html
        System.out.println(test.split("[\\p{P} ]").length);
        for (String s : test.split("[\\p{P} ]")){
            System.out.println(s);
        }
    }
}
