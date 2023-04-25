/**
 * Given an array A containing n + 1 integers where each
 * integer is between 1 and n (inclusive),
 * prove that at least one duplicate number must exist.
 * Assume that there is only one duplicate number, find the duplicate one.
 * -
 * Example:
 * Input: [1,3,2,4,2,5]
 * Output: 2
 */
public class FindDuplicateNumber {
    public int findDuplicateNumber(int[] array) {
        int tortoise = array[0];
        int hare = array[0];
        do {
            tortoise = array[tortoise];
            hare = array[array[hare]];
        } while (tortoise != hare);

        tortoise = array[0];
        while (tortoise != hare) {
            tortoise = array[tortoise];
            hare = array[hare];
        }

        return tortoise;
    }
}
