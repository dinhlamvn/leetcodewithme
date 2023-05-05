import java.util.*;

/**
 * You are given a string s and an array of strings words. All the strings of words
 * are of the same length.
 * A concatenated substring in s is a substring that contains all the
 * strings of any permutation of words concatenated.
 * For example, if words = ["ab","cd","ef"], then "abcdef", "abefcd", "cdabef", "cdefab", "efabcd", and "efcdab" are all concatenated strings. "acdbef" is not a concatenated substring because it is not the concatenation of any permutation of words.
 * Return the starting indices of all the concatenated substrings in s. You can return the answer in any order.
 * */
public class SubstringWithConcatenationOfAllWords {

    public List<Integer> findSubstring(String s, String[] words) {
        final List<Integer> ret = new ArrayList<>();
        Map<String, Integer> map = new HashMap<>();
        for (String w : words) {
            final int num = map.getOrDefault(w, 0);
            map.put(w, num + 1);
        }

        int k = words[0].length();
        for (int i = 0; i <= s.length() - k * words.length; ++i) {

            int cnt = 0;
            int x = i;

            Map<String, Integer> mapTemp = new HashMap<>(map);
            while (x < s.length()) {
                int m = x;
                int n = m + k;
                final StringBuilder sb = new StringBuilder();
                while (m < n && m < s.length()) {
                    sb.append(s.charAt(m));
                    m++;
                }

                final int num = mapTemp.getOrDefault(sb.toString(), 0);
                if (num <= 0) {
                    break;
                } else {
                    cnt++;
                    mapTemp.put(sb.toString(), num - 1);
                }

                x += k;
            }

            if (cnt == words.length) {
                ret.add(i);
            }
        }

        return ret;
    }
}
