import java.util.*;

public class TreePathProblems {
    public static class TreeNode {
        int val;
        TreeNode left, right;
        TreeNode(int val) { this.val = val; }
    }
    
    public static List<List<Integer>> allRootToLeafPaths(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null) return result;
        
        List<Integer> currentPath = new ArrayList<>();
        findAllPaths(root, currentPath, result);
        return result;
    }
    
    private static void findAllPaths(TreeNode node, List<Integer> currentPath, List<List<Integer>> result) {
        if (node == null) return;
        
        currentPath.add(node.val);
        
        if (node.left == null && node.right == null) {
            result.add(new ArrayList<>(currentPath));
        } else {
            findAllPaths(node.left, currentPath, result);
            findAllPaths(node.right, currentPath, result);
        }
        
        currentPath.remove(currentPath.size() - 1);
    }
    
    public static boolean hasPathSum(TreeNode root, int targetSum) {
        if (root == null) return false;
        
        if (root.left == null && root.right == null) {
            return root.val == targetSum;
        }
        
        int remainingSum = targetSum - root.val;
        return hasPathSum(root.left, remainingSum) || hasPathSum(root.right, remainingSum);
    }
    
    public static List<Integer> maxSumPath(TreeNode root) {
        if (root == null) return new ArrayList<>();
        
        List<Integer> maxPath = new ArrayList<>();
        List<Integer> currentPath = new ArrayList<>();
        int[] maxSum = {Integer.MIN_VALUE};
        
        findMaxSumPath(root, currentPath, 0, maxPath, maxSum);
        return maxPath;
    }
    
    private static void findMaxSumPath(TreeNode node, List<Integer> currentPath, 
                                     int currentSum, List<Integer> maxPath, int[] maxSum) {
        if (node == null) return;
        
        currentPath.add(node.val);
        currentSum += node.val;
        
        if (node.left == null && node.right == null) {
            if (currentSum > maxSum[0]) {
                maxSum[0] = currentSum;
                maxPath.clear();
                maxPath.addAll(currentPath);
            }
        } else {
            findMaxSumPath(node.left, currentPath, currentSum, maxPath, maxSum);
            findMaxSumPath(node.right, currentPath, currentSum, maxPath, maxSum);
        }
        
        currentPath.remove(currentPath.size() - 1);
    }
    
    public static void main(String[] args) {
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(4);
        root.right = new TreeNode(8);
        root.left.left = new TreeNode(11);
        root.left.left.left = new TreeNode(7);
        root.left.left.right = new TreeNode(2);
        root.right.left = new TreeNode(13);
        root.right.right = new TreeNode(4);
        root.right.right.right = new TreeNode(1);
        
        System.out.println("所有路徑：" + allRootToLeafPaths(root));
        System.out.println("和為22的路徑存在：" + hasPathSum(root, 22));
        System.out.println("最大和路徑：" + maxSumPath(root));
    }
}
