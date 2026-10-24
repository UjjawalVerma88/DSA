/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */


// class Solution {
//     public void inorder(TreeNode root, List<Integer> ans){
//         if(root == null) return;
//         inorder(root.left,ans);
//         ans.add(root.val);
//         inorder(root.right,ans);
//     }
//     public List<Integer> inorderTraversal(TreeNode root) {
//         List<Integer> ans = new ArrayList<>();
//         inorder(root,ans);
//         return ans;
//     }
// }


class Solution {
    public List<Integer> inorderTraversal(TreeNode root) {
        ArrayList<Integer> ans = new ArrayList<>();
        Stack<TreeNode> st = new Stack<>();

        TreeNode curr = root;

        while (st.size() > 0 || curr != null) {
            if (curr != null) {
                if (curr.left != null) {
                    st.push(curr);
                    curr = curr.left;
                } else {
                    ans.add(curr.val);
                    curr = curr.right;
                }
            } else {
                TreeNode top = st.pop();
                ans.add(top.val);
                curr = top.right;
            }
        }
        return ans;
    }
}