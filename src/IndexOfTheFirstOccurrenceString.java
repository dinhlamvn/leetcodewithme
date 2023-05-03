/**
 * Given two strings needle and haystack, return the index of
 * the first occurrence of needle in haystack, or -1 if needle is not part of haystack.
 * --
 * Example 1:
 * Input: haystack = "sadbutsad", needle = "sad"
 * Output: 0
 * */
public class IndexOfTheFirstOccurrenceString {
    public int strStr(String haystack, String needle) {
        for (int i = 0; i < haystack.length(); ++i) {
            int k = 0, j = i;
            while (k < needle.length() && j < haystack.length() && haystack.charAt(j) == needle.charAt(k)) {
                k++;
                j++;
            }

            if (k == needle.length()) {
                return i;
            }
        }

        return -1;
    }
}
