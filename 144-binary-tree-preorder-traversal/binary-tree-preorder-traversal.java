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
//     public void preorder(TreeNode root, List<Integer> ans){
//         if(root == null) return;
//         ans.add(root.val);
//         preorder(root.left,ans);
//         preorder(root.right,ans);

//     }
//     public List<Integer> preorderTraversal(TreeNode root) {
//         List<Integer> ans = new ArrayList<>();
//         preorder(root,ans);
//         return ans;
//     }
// }

class Solution {
    
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        Stack<TreeNode> st = new Stack<>();

        if(root == null) return list;
        st.push(root);
        while(st.size()>0){
            TreeNode curr = st.pop();
            list.add(curr.val);
            if(curr.right!=null) st.add(curr.right);
            if(curr.left!=null) st.add(curr.left);

        }
        return list;
    }
}