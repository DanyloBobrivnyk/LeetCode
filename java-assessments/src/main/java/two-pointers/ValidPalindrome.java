//https://leetcode.com/problems/valid-palindrome/
class Solution {
    public boolean isPalindrome(String s) {
        char[] sArr = s
                .replaceAll("\\W+","")
                .replaceAll("_","")
                .toLowerCase()
                .toCharArray();

        for (int l = 0, r = sArr.length-1; l < sArr.length; l++, r--) {
            if (l == r || l > r) {
                return true;
            }

            if (sArr[l] != sArr[r]) {
                return false;
            }
        }

        return true;
    }
}
