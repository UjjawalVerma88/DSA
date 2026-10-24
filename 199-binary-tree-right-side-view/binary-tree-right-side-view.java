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
//     public List<Integer> bfs(TreeNode root) {
//         List<Integer> ans = new ArrayList<>();

//         if (root == null) return ans;
//         Queue<TreeNode> q = new LinkedList<>();
//         q.add(root);

//         while (!q.isEmpty()) {
//             int size = q.size();

//             for (int i = 0; i < size; i++) {
//                 TreeNode front = q.remove();

//                 // Current level ka last node
//                 if (i == size - 1) ans.add(front.val);
//                 if (front.left != null) q.add(front.left);
//                 if (front.right != null) q.add(front.right);
//             }
//         }
//         return ans;
//     }

//     public List<Integer> rightSideView(TreeNode root) {
//         return bfs(root);
//     }
// }

// class Solution {
//     public void preOrder(TreeNode root, int level, List<Integer> result) {
//         if (root == null) {
//             return;
//         }

//         if (result.size() < level) {
//             result.add(root.val);
//         }

//         preOrder(root.right, level + 1, result);
//         preOrder(root.left, level + 1, result);
//     }

//     public List<Integer> rightSideView(TreeNode root) {
//         List<Integer> result = new ArrayList<>();

//         preOrder(root, 1, result);

//         return result;
//     }
// }

class Solution {
    public void view(TreeNode root, int level, List<Integer> ans){
        if(root == null) return;
        if(level>=ans.size()) ans.add(root.val);
        else ans.set(level,root.val);
        view(root.left,level+1,ans);
        view(root.right,level+1,ans);
    }
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        view(root,0,ans);
        return ans;
    }
}

