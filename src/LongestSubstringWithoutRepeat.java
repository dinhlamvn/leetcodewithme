
/**
 * Give a string s, find the longest substring without repeat character
 * -
 * Example 1:
 * Input: abcababbbc
 * Output: abc, with length is 3
 * */
public class LongestSubstringWithoutRepeat {

    public String longestSubstring(String s) {
        int[] mark = new int[26];
        final StringBuilder sb = new StringBuilder();
        int max = 0;
        String ret = "";

        for (int i = 0; i < 26; ++i) mark[i] = -1;

        for (int i = 0; i < s.length(); ++i) {
            char c = s.charAt(i);
            int code = c - 'a';
            if (mark[code] == -1) {
                mark[code] = i;
                sb.append(c);
            } else {
                int index = mark[code];
                mark[code] = -1;
                i = index;
                if (sb.length() > max) {
                    max = sb.length();
                    ret = sb.toString();
                }
                sb.setLength(0);
            }
        }

        if (sb.length() > max) {
            return sb.toString();
        }

        return ret;
    }
}
