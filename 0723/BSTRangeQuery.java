import java.util.ArrayList;

public class BSTRangeQuery {
    
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        
        TreeNode(int val) {
            this.val = val;
            this.left = null;
            this.right = null;
        }
    }
    
    public static ArrayList<Integer> rangeQuery(TreeNode root, int min, int max) {
        ArrayList<Integer> result = new ArrayList<>();
        rangeQueryHelper(root, min, max, result);
        return result;
    }
    
    private static void rangeQueryHelper(TreeNode node, int min, int max, ArrayList<Integer> result) {
        if (node == null) {
            return;
        }
        
        if (node.val > min) {
            rangeQueryHelper(node.left, min, max, result);
        }
        
        if (node.val >= min && node.val <= max) {
            result.add(node.val);
        }
        
        if (node.val < max) {
            rangeQueryHelper(node.right, min, max, result);
        }
    }
    
    public static TreeNode insert(TreeNode root, int val) {
        if (root == null) {
            return new TreeNode(val);
        }
        
        if (val < root.val) {
            root.left = insert(root.left, val);
        } else if (val > root.val) {
            root.right = insert(root.right, val);
        }
        
        return root;
    }
    
    public static void inOrder(TreeNode root) {
        if (root == null) {
            return;
        }
        inOrder(root.left);
        System.out.print(root.val + " ");
        inOrder(root.right);
    }
    
    public static void main(String[] args) {
        System.out.println("=== BST範圍查詢 ===");
        
        TreeNode root = null;
        int[] values = {20, 10, 30, 5, 15, 25, 35};
        
        for (int val : values) {
            root = insert(root, val);
        }
        
        System.out.print("BST結構（中序走訪）：");
        inOrder(root);
        System.out.println();
        
        int min = 12, max = 27;
        ArrayList<Integer> result = rangeQuery(root, min, max);
        
        System.out.printf("範圍查詢[%d, %d]結果：%s\n", min, max, result);
    }
}
