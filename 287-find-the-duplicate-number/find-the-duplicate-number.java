class Solution {

    public static void swap(int[] nums, int i, int idx) {
        int temp = nums[i];
        nums[i] = nums[idx];
        nums[idx] = temp;
    }

    public int findDuplicate(int[] nums) {

        int i = 0;

        while (i < nums.length) {

            if (nums[i] != i + 1) {

                int idx = nums[i] - 1;

                // Duplicate found
                if (nums[i] == nums[idx]) {
                    return nums[i];
                }

                swap(nums, i, idx);

            } else {
                i++;
            }
        }

        return -1;
    }
}