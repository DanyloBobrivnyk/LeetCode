//https://leetcode.com/problems/contains-duplicate/
class ContainsDuplicate {
    public boolean containsDuplicate(int[] nums) {
        int numsSize = nums.length;
        HashSet<Integer> hashSet = new HashSet<>(numsSize);

        for (int i =0; i < numsSize; i++)
        {
            hashSet.add(nums[i]);
        }

        //Contains duplicate? If sizes are the same - no
        return !(hashSet.size() == numsSize);
    }
}