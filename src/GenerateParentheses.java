import java.util.LinkedList;
import java.util.List;

/**
 * Given n pairs of parentheses, write a function to generate all
 * combinations of well-formed parentheses.
 * -
 * Example 1:
 * Input: n = 3
 * Output: ["((()))","(()())","(())()","()(())","()()()"]
 * -
 * Example 2:
 * Input: n = 1
 * Output: ["()"]
 * -
 * Constraints:
 * 1 <= n <= 8
 * */
public class GenerateParentheses {

    public List<String> generateParenthesis(int n) {
        final List<String> ret = new LinkedList<>();
        final StringBuilder sb = new StringBuilder();

        if (n == 0) {
            ret.add("");
        } else {
            for (int i = 0; i < n; ++i) {
                // Find the ( and ) in the left, because every parentheses sequence
                // has a unique closure number.
                final List<String> left = generateParenthesis(i);
                for (String value : left) {
                    final List<String> right = generateParenthesis(n - i - 1);
                    for (String s : right) {
                        sb.append("(").append(value).append(")").append(s);
                        ret.add(sb.toString());
                        sb.setLength(0);
                    }
                }
            }
        }

        return ret;
    }
}
