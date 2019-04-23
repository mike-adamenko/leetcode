/**
 *
 */
public class GetLongestSubseq {
    public static void main(String[] args) {
        System.out.println(new GetLongestSubseq().getLongestSubsequence("“AAPPPPPPPPPAAAAAXXXCDDDEEEEBBBNNNE"));
    }

    public String getLongestSubsequence(String text) {

        char[] c = text.toCharArray();
        String longest = "";
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < text.length(); i++)

        {

            char curr = text.charAt(i);
            char next = i != c.length - 1 ? c[i + 1] : '\0';
            sb.append(curr);
            if (curr != next) {
                String temp = sb.toString();
                if (temp.length() > longest.length()) {
                    longest = temp;
                }
                sb.setLength(0);
            }
        }
        return longest;
    }


}