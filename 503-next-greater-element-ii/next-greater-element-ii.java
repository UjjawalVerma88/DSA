class Solution {
    public int[] nextGreaterElements(int[] nums) {
        int n = nums.length;
        Stack<Integer> st = new Stack<>();
        int[] nge = new int[n];

//      firstly push all elements into the stack
        for(int i = n-1; i>=0; i--){
            st.push(nums[i]);
        }

        for(int i = n-1; i>=0; i--){
            while(st.size()>0 && nums[i]>=st.peek()){
                st.pop();
            }
            if (st.size() == 0) {
                nge[i] = -1;
            } else {
                nge[i] = st.peek();
            }
            st.push(nums[i]);
        }
        return nge;

    }
}