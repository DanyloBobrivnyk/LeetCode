import java.util.*;
import java.util.stream.Collectors;
//https://leetcode.com/problems/longest-consecutive-sequence/submissions/1249104771/
class Solution {
    public int longestConsecutive(int[] nums) {
        if (nums.length == 0) return 0;
        Set<Integer> set = Arrays.stream(nums).boxed().collect(Collectors.toSet());
        int longest = 0;

        //
        for (var elem : set) {
            if (!set.contains(elem-1)) {
                int count = 1;
                int num = elem;
                while (set.contains(num+1)) {
                    num++;
                    count++;
                }
                longest = Math.max(longest, count);
            }
        }
        return longest;
    }
}