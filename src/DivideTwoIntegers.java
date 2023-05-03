/**
 * Given two integers dividend and divisor, divide two integers without using multiplication,
 * division, and mod operator.
 * The integer division should truncate toward zero, which means losing its
 * fractional part. For example, 8.345 would be truncated to 8, and -2.7335 would be truncated to -2.
 * ---
 * Example 1:
 * Input: dividend = 10, divisor = 3
 * Output: 3
 * */
public class DivideTwoIntegers {
    public int divide(int dividend, int divisor) {
        int neg = dividend < 0 ^ divisor < 0 ? -1 : 1;
        double a = Math.abs((long) dividend);
        double b = Math.abs((long) divisor);
        if (b > a) {
            return 0;
        }
        double ret = Math.exp(Math.log(a) - Math.log(b)) + 0.000001;

        ret = neg < 0 ? -ret : ret;
        return ret < Integer.MIN_VALUE ? Integer.MIN_VALUE : (ret > Integer.MAX_VALUE ? Integer.MAX_VALUE : (int) ret);
    }
}
