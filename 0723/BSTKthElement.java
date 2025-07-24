public class BSTKthElement {
    
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
    
    private static int count;
    private static int result;
    
    public static int kthSmallest(TreeNode root, int k) {
        count = 0;
        result = -1;
        inorderTraversal(root, k);
        return result;
    }
    
    private static void inorderTraversal(TreeNode node, int k) {
        if (node == null || count >= k) {
            return;
        }
        
        inorderTraversal(node.left, k);
        
        count++;
        if (count == k) {
            result = node.val;
            return;
        }
        
        inorderTraversal(node.right, k);
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
        System.out.println("=== BST第k小元素 ===");
        
        TreeNode root = null;
        int[] values = {20, 10, 30, 5, 15, 25, 35, 1, 7, 12, 18};
        
        for (int val : values) {
            root = insert(root, val);
        }
        
        System.out.print("BST中序走訪：");
        inOrder(root);
        System.out.println();
        
        for (int k = 1; k <= 6; k++) {
            int kthElement = kthSmallest(root, k);
            System.out.printf("第%d小的元素：%d\n", k, kthElement);
        }
    }
}
