/**
 * https://leetcode.com/problems/binary-tree-maximum-path-sum/
 * 124. Binary Tree Maximum Path Sum
 * Hard
 * <p>
 * 1270
 * <p>
 * 91
 * <p>
 * Favorite
 * <p>
 * Share
 * Given a non-empty binary tree, find the maximum path sum.
 * <p>
 * For this problem, a path is defined as any sequence of nodes from some starting node to any node in the tree along the parent-child connections. The path must contain at least one node and does not need to go through the root.
 * <p>
 * Example 1:
 * <p>
 * Input: [1,2,3]
 * <p>
 * 1
 * / \
 * 2   3
 * <p>
 * Output: 6
 * Example 2:
 * <p>
 * Input: [-10,9,20,null,null,15,7]
 * <p>
 * -10
 * / \
 * 9  20
 * /  \
 * 15   7
 * <p>
 * Output: 42
 */

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class BinaryTree1 {


    TreeNode root;


    public static void main(String[] args) {
        BinaryTree1 t2 = new BinaryTree1();
        Integer[] arr = {-10, 9, 20, null, null, 15, 7};
        t2.root = t2.insertLevelOrder(arr, t2.root, 0);
//        t2.inOrder(t2.root);
    new BTreePrinter().printNode(t2.root);
    }

    int max = Integer.MIN_VALUE;
    public int maxPathSum(TreeNode root) {
        helper(root);
        return max;
    }

    public int helper(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int left = helper(root.left);
        int right = helper(root.right);
        max = Math.max(max, root.val+left+right);
        int current = root.val + Math.max(left, right);
        return (current > 0) ? current : 0;
    }

    // Function to insert nodes in level order
    public TreeNode insertLevelOrder(Integer[] arr, TreeNode root,
                                 int i)
    {
        // Base case for recursion
        if (i < arr.length) {
            if (arr[i]!= null){


            TreeNode temp = new TreeNode(arr[i]);
            root = temp;

            // insert left child
            root.left = insertLevelOrder(arr, root.left,
                    2 * i + 1);

            // insert right child
            root.right = insertLevelOrder(arr, root.right,
                    2 * i + 2);
            }
        }
        return root;
    }

    // Function to print tree nodes in InOrder fashion
    public void inOrder(TreeNode root)
    {
        if (root != null) {
            inOrder(root.left);
            System.out.print(root.val + " ");
            inOrder(root.right);
        }
    }
}
