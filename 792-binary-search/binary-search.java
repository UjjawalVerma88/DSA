class Solution {
    // public int search(int[] nums, int target) {
    //     int low = 0 , high = nums.length-1, mid;

    //     while (low<=high){
    //         mid = (low + high )/ 2;

    //         if(nums[mid] == target){
    //             return mid;
    //         }
    //         else if(nums[mid]<target){
    //             low = mid + 1;
    //         }
    //         else{
    //             high = mid -1;

    //         }
            
    //     }
    //     return -1;
    // }

    public int helper(int[] nums, int target, int lo , int high){
        if(lo > high) return -1;
        int mid = lo + (high-lo)/2;
        if(nums[mid] == target) return mid;
        else if(nums[mid]> target) return helper(nums,target,lo,mid-1);
        else return helper(nums,target,mid+1,high);
        
    }

    public int search(int[] nums, int target) {
        int length = nums.length;
        return helper(nums,target,0,length-1);
    }
}