class Solution {
    public int[] findErrorNums(int[] nums) {

        int i = 0;

        // Cyclic Sort
        while (i < nums.length) {

            int correctIndex = nums[i] - 1;

            if (nums[i] != nums[correctIndex]) {
                swap(nums, i, correctIndex);
            } else {
                i++;
            }
        }

        // Find duplicate and missing
        for (i = 0; i < nums.length; i++) {

            if (nums[i] != i + 1) {
                return new int[]{nums[i], i + 1};
            }
        }

        return new int[]{-1, -1};
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}