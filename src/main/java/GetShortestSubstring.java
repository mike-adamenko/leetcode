import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

//Time Complexity: O(w + ws)
//Space Complexity: O(s)
//Where w is the number of words in the document, and s is the number of search terms
public class GetShortestSubstring {
    private Map<String, Integer> snippetDataPoints = new HashMap<String, Integer>();
    private String[] words, searchTerms;
    private int shortestSnippetStart = 0, shortestSnippetEnd, currentSnippetStart = 0;

    public static String solution(String document, String[] searchTerms) {
        GetShortestSubstring solution = new GetShortestSubstring(document.split(" "), searchTerms);//document.split isnt the most efficient, but we are already over O(n), and this keeps it simple
        return solution.solve();
    }

    private GetShortestSubstring(String[] words, String[] searchTerms){
        this.words = words;
        this.searchTerms = searchTerms;
        shortestSnippetEnd=words.length;
    }

    private String solve(){
        for(int i=0;i<words.length;i++){
            if(searchTermsContains(words[i])){
                addToSnippet(words[i], i);
            }
        }
        StringBuilder snippet = new StringBuilder();
        for(int i = shortestSnippetStart; i<=shortestSnippetEnd; i++){
            snippet.append(words[i] + " ");
        }
        snippet.deleteCharAt(snippet.length()-1);
        return snippet.toString();
    }

    private void addToSnippet(String word, int position) {
        Integer previousPosition = snippetDataPoints.put(word, position);
        if(previousPosition == null || previousPosition <= currentSnippetStart){
            currentSnippetStart = Collections.min(snippetDataPoints.values());
        }
        if(snippetDataPoints.size() == searchTerms.length){
            determineShortestSnippet(position);
        }
    }

    private void determineShortestSnippet(int currentPositionEnd) {
        if(shortestSnippetEnd - shortestSnippetStart > currentPositionEnd - currentSnippetStart ){
            shortestSnippetStart = currentSnippetStart;
            shortestSnippetEnd = currentPositionEnd;
        }
    }

    private boolean searchTermsContains(String word) {
        for(String searchTerm : searchTerms){
            if(searchTerm.equals(word)) return true;
        }
        return false;
    }

    public static void main(String[] args) {
        String[] arr = {"question", "to", "be"};
        System.out.println(GetShortestSubstring.solution("to be or not to be what is a question to be question", arr));
    }
}