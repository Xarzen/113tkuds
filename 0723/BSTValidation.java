import java.util.*;

public class BSTValidation {
    public static class TreeNode {
        int val;
        TreeNode left, right;
        TreeNode(int val) { this.val = val; }
    }
    
    public static boolean isValidBST(TreeNode root) {
        return validate(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }
    
    private static boolean validate(TreeNode node, long min, long max) {
        if (node == null) return true;
        if (node.val <= min || node.val >= max) return false;
        return validate(node.left, min, node.val) && 
               validate(node.right, node.val, max);
    }
    
    public static List<Integer> findInvalidNodes(TreeNode root) {
        List<Integer> invalid = new ArrayList<>();
        findInvalid(root, Long.MIN_VALUE, Long.MAX_VALUE, invalid);
        return invalid;
    }
    
    private static void findInvalid(TreeNode node, long min, long max, List<Integer> invalid) {
        if (node == null) return;
        
        if (node.val <= min || node.val >= max) {
            invalid.add(node.val);
        }
        
        findInvalid(node.left, min, node.val, invalid);
        findInvalid(node.right, node.val, max, invalid);
    }
    
    public static int minNodesToRemove(TreeNode root) {
        List<Integer> inorder = new ArrayList<>();
        inorderTraversal(root, inorder);
        
        int totalNodes = inorder.size();
        int longestIncreasing = findLongestIncreasingSubsequence(inorder);
        
        return totalNodes - longestIncreasing;
    }
    
    private static void inorderTraversal(TreeNode node, List<Integer> result) {
        if (node == null) return;
        inorderTraversal(node.left, result);
        result.add(node.val);
        inorderTraversal(node.right, result);
    }
    
    private static int findLongestIncreasingSubsequence(List<Integer> nums) {
        if (nums.isEmpty()) return 0;
        
        int[] dp = new int[nums.size()];
        Arrays.fill(dp, 1);
        
        for (int i = 1; i < nums.size(); i++) {
            for (int j = 0; j < i; j++) {
                if (nums.get(j) < nums.get(i)) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
        }
        
        return Arrays.stream(dp).max().orElse(0);
    }
    
    public static void main(String[] args) {
        TreeNode validBST = new TreeNode(5);
        validBST.left = new TreeNode(3);
        validBST.right = new TreeNode(7);
        validBST.left.left = new TreeNode(2);
        validBST.left.right = new TreeNode(4);
        validBST.right.left = new TreeNode(6);
        validBST.right.right = new TreeNode(8);
        
        TreeNode invalidBST = new TreeNode(5);
        invalidBST.left = new TreeNode(3);
        invalidBST.right = new TreeNode(7);
        invalidBST.left.left = new TreeNode(2);
        invalidBST.left.right = new TreeNode(6);
        invalidBST.right.left = new TreeNode(4);
        invalidBST.right.right = new TreeNode(8);
        
        System.out.println("有效BST驗證：" + isValidBST(validBST));
        System.out.println("無效BST驗證：" + isValidBST(invalidBST));
        System.out.println("無效節點：" + findInvalidNodes(invalidBST));
        System.out.println("需移除節點數：" + minNodesToRemove(invalidBST));
    }
}
