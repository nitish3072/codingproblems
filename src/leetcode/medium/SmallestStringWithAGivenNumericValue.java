package leetcode.medium;

/**
 * https://leetcode.com/problems/smallest-string-with-a-given-numeric-value/
 */
public class SmallestStringWithAGivenNumericValue {

    public String getSmallestString(int n, int k) {
        StringBuilder finalRes = new StringBuilder();
        int currentRemainingInK = k;
        for (int i = 1; i < n; i++) {
            int nextTryingElement = (currentRemainingInK / (n - i) > 26 || (currentRemainingInK / (n - i) == 26 && currentRemainingInK % (n - i)!=0)) ? currentRemainingInK - (n - i) * 26: 1;
            // Put alphabet a in current block and check if remaining blocks can satisfy the currentRemainingInK.
            // This check is necessary because suppose 2 blocks are left then currentRemainingInK should be less that 52
            currentRemainingInK = currentRemainingInK - nextTryingElement;
            finalRes.append((char) (nextTryingElement + 96));
        }
        return finalRes.append((char) (currentRemainingInK + 96)).toString();
    }

    public static void main(String[] args) {
        SmallestStringWithAGivenNumericValue smallestStringWithAGivenNumericValue = new SmallestStringWithAGivenNumericValue();
        System.out.println(smallestStringWithAGivenNumericValue.getSmallestString(5, 73));
    }

}
