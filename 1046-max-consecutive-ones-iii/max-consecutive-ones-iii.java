class Solution {
    public int longestOnes(int[] nums, int k) {
        int left = 0, zeroes = 0, length = 0;
        int maxlength = 0;

        for(int right = 0; right<nums.length; right++){
            if(nums[right] == 0){
                zeroes++;
            }

            while(zeroes>k){
                if(nums[left] == 0){
                    zeroes--;
                }
                left++;
            }

            length = right - left + 1;
            maxlength = Math.max(maxlength, length);
        }
        return maxlength;
    }
}