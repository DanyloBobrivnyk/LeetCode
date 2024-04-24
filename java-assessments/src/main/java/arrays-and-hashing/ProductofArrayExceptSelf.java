//https://leetcode.com/problems/product-of-array-except-self/description/
class Solution {
    public int[] productExceptSelf(int[] nums) {
        int[] prefix = calculatePrefix(nums);
        int[] postfix = calculatePostfix(nums);
        int[] result = new int[nums.length];

        for (int i = 0; i < nums.length; i++) {
            int prefixVal = i == 0 ? 1 : prefix[i-1];
            int postfixVal = i == nums.length - 1 ? 1 : postfix[i+1];

            result[i] = prefixVal * postfixVal;
        }

        return result;
    }

    private int[] calculatePrefix(int[] nums) {
        int[] prefix = new int[nums.length];

        for (int i = 0; i < nums.length; i++) {
            if (i == 0) {
                prefix[i] = 1 * nums[i];
                continue;
            }

            prefix[i] = nums[i] * prefix[i - 1];
        }
        return prefix;
    }

    private int[] calculatePostfix(int[] nums) {
        int[] postfix = new int[nums.length];

        for (int i = nums.length - 1; i >= 0; i--) {
            if (i == nums.length - 1) {
                postfix[i] = 1 * nums[i];
                continue;
            }

            postfix[i] = nums[i] * postfix[i + 1];
        }

        return postfix;
    }
}