class Solution {
    public int longestConsecutive(int[] nums) {

        Set<Integer> set = new HashSet<>();

        // Put all numbers into HashSet
        for (int num : nums) {
            set.add(num);
        }

        int longest = 0;

        // Check every unique number
        for (int num : set) {

            // num is the starting point
            if (!set.contains(num - 1)) {

                int current = num;
                int length = 1;

                // Find num+1, num+2, num+3...
                while (set.contains(current + 1)) {
                    current++;
                    length++;
                }

                longest = Math.max(longest, length);
            }
        }

        return longest;
    }
}