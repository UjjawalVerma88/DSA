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
import java.util.*;

class Pair {
    TreeNode node;
    int level;

    Pair(TreeNode node, int level) {
        this.node = node;
        this.level = level;
    }
}

class Solution {
    public void levelOrderlinewise(TreeNode root, List<List<Integer>> list) {
        if (root == null) return;
        Queue<Pair> q = new LinkedList<>();
        int currLevel = 0;

        q.add(new Pair(root, 0));
        list.add(new ArrayList<>());

        while (!q.isEmpty()) {
            Pair front = q.remove();
            if (front.level != currLevel) {
                currLevel = front.level;
                list.add(new ArrayList<>());
            }

            list.get(currLevel).add(front.node.val);

            if (front.node.left != null) {
                q.add(new Pair(front.node.left, front.level + 1));
            }

            if (front.node.right != null) {
                q.add(new Pair(front.node.right, front.level + 1));
            }
        }
    }
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> list = new ArrayList<>();
        levelOrderlinewise(root, list);
        return list;
    }
}