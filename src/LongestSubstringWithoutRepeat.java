
/**
 * Give a string s, find the longest substring without repeat character
 * -
 * Example 1:
 * Input: abcababbbc
 * Output: abc, with length is 3
 * */
public class LongestSubstringWithoutRepeat {

    public String longestSubstring(String s) {
        final StringBuilder sb = new StringBuilder();
        String ret = "";

        for (int i = 0; i < s.length(); ++i) {
            char c = s.charAt(i);
            int index = sb.indexOf(String.valueOf(c));
            if (index == -1) {
                sb.append(c);
            } else {
                if (sb.length() > ret.length()) {
                    ret = sb.toString();
                }
                sb.append(c);
                sb.delete(0, index + 1);
            }
        }

        if (sb.length() > ret.length()) {
            return sb.toString();
        }

        return ret;
    }
}
