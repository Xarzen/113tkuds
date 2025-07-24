import java.util.ArrayList;
import java.util.List;

public class TreeDistance {
    public static class TreeNode {
        int val;
        TreeNode left, right;
        TreeNode(int val) { this.val = val; }
    }
    
    public static int distanceBetweenNodes(TreeNode root, int val1, int val2) {
        TreeNode lca = findLCA(root, val1, val2);
        int dist1 = findDistance(lca, val1, 0);
        int dist2 = findDistance(lca, val2, 0);
        return dist1 + dist2;
    }
    
    private static TreeNode findLCA(TreeNode node, int val1, int val2) {
        if (node == null) return null;
        if (node.val == val1 || node.val == val2) return node;
        
        TreeNode left = findLCA(node.left, val1, val2);
        TreeNode right = findLCA(node.right, val1, val2);
        
        if (left != null && right != null) return node;
        return left != null ? left : right;
    }
    
    private static int findDistance(TreeNode node, int target, int dist) {
        if (node == null) return -1;
        if (node.val == target) return dist;
        
        int leftDist = findDistance(node.left, target, dist + 1);
        if (leftDist != -1) return leftDist;
        
        return findDistance(node.right, target, dist + 1);
    }
    
    public static int treeDiameter(TreeNode root) {
        int[] diameter = {0};
        calculateHeight(root, diameter);
        return diameter[0];
    }
    
    private static int calculateHeight(TreeNode node, int[] diameter) {
        if (node == null) return 0;
        
        int leftHeight = calculateHeight(node.left, diameter);
        int rightHeight = calculateHeight(node.right, diameter);
        
        diameter[0] = Math.max(diameter[0], leftHeight + rightHeight);
        
        return Math.max(leftHeight, rightHeight) + 1;
    }
    
    public static List<Integer> nodesAtDistance(TreeNode root, int distance) {
        List<Integer> result = new ArrayList<>();
        findNodesAtDistance(root, distance, result);
        return result;
    }
    
    private static void findNodesAtDistance(TreeNode node, int distance, List<Integer> result) {
        if (node == null) return;
        
        if (distance == 0) {
            result.add(node.val);
            return;
        }
        
        findNodesAtDistance(node.left, distance - 1, result);
        findNodesAtDistance(node.right, distance - 1, result);
    }
    
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(7);
        
        System.out.println("節點4和7之間距離：" + distanceBetweenNodes(root, 4, 7));
        System.out.println("樹的直徑：" + treeDiameter(root));
        System.out.println("距離根節點2的節點：" + nodesAtDistance(root, 2));
    }
}
