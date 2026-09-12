class Solution {
    public static void Subset(List<Integer> ans, int[] nums, int index, List<List<Integer>> list) {

        if (index == nums.length) {
            list.add(new ArrayList<>(ans));
            return;
        }

        // Take
        ans.add(nums[index]);
        Subset(ans, nums, index + 1, list);

        // Don't take
        ans.remove(ans.size() - 1);
        Subset(ans, nums, index + 1, list);
    }
    public List<List<Integer>> subsets(int[] nums) {
        List<Integer> ans = new ArrayList<>();
        List<List<Integer>> list = new ArrayList<>();

        Subset(ans, nums, 0, list);

        return list;
    }
}