import java.io.Serializable;
import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

//https://leetcode.com/problems/group-anagrams/description/
public class GroupAnagrams {
    public List<List<String>> groupAnagrams(String[] strs) {
        /*
        * 1 - First element to res
        * 2 - Check this element
        *       2.1 - Anagram ? - Add it to the group
        *       2.2 - Not Anagram
        *           2.2.1 - Check other groups
        *               2.2.1.1 - No groups? - Add group
        * */

        List<List<String>> res = new ArrayList<>();
        Map<String, List<String>> map = new HashMap<>();



        //Declarative style
        /*for (String str : strs) {
            char[] chars = str.toCharArray();
            Arrays.sort(chars);
            String word = new String(chars);
            if (!map.containsKey(word)) {
                map.put(word, new ArrayList<>());
            }
            map.get(word).add(str);
        }

        res.addAll(map.values());
        return res;*/
        // Imperative style
        res.addAll(
            Arrays.stream(strs)
                .collect(Collectors.groupingBy(this::sortTheWord))
                .values()
        );

        return res;
    }

    public <T extends String> String sortTheWord(T str){
        char[] chars = str.toCharArray();
        Arrays.sort(chars);
        return new String(chars);
    }
}
