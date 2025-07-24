public class BSTBalance {
    public static class TreeNode {
        int val;
        TreeNode left, right;
        TreeNode(int val) { this.val = val; }
    }
    
    public static boolean isBalanced(TreeNode root) {
        return checkBalance(root) != -1;
    }
    
    private static int checkBalance(TreeNode node) {
        if (node == null) return 0;
        
        int leftHeight = checkBalance(node.left);
        if (leftHeight == -1) return -1;
        
        int rightHeight = checkBalance(node.right);
        if (rightHeight == -1) return -1;
        
        if (Math.abs(leftHeight - rightHeight) > 1) return -1;
        
        return Math.max(leftHeight, rightHeight) + 1;
    }
    
    public static int getBalanceFactor(TreeNode node) {
        if (node == null) return 0;
        
        int leftHeight = getHeight(node.left);
        int rightHeight = getHeight(node.right);
        
        return leftHeight - rightHeight;
    }
    
    private static int getHeight(TreeNode node) {
        if (node == null) return 0;
        return Math.max(getHeight(node.left), getHeight(node.right)) + 1;
    }
    
    public static TreeNode findMostUnbalancedNode(TreeNode root) {
        TreeNode[] result = {null};
        int[] maxImbalance = {0};
        
        findMostUnbalanced(root, result, maxImbalance);
        return result[0];
    }
    
    private static void findMostUnbalanced(TreeNode node, TreeNode[] result, int[] maxImbalance) {
        if (node == null) return;
        
        int balanceFactor = Math.abs(getBalanceFactor(node));
        if (balanceFactor > maxImbalance[0]) {
            maxImbalance[0] = balanceFactor;
            result[0] = node;
        }
        
        findMostUnbalanced(node.left, result, maxImbalance);
        findMostUnbalanced(node.right, result, maxImbalance);
    }
    
    public static void main(String[] args) {
        TreeNode balancedBST = new TreeNode(4);
        balancedBST.left = new TreeNode(2);
        balancedBST.right = new TreeNode(6);
        balancedBST.left.left = new TreeNode(1);
        balancedBST.left.right = new TreeNode(3);
        balancedBST.right.left = new TreeNode(5);
        balancedBST.right.right = new TreeNode(7);
        
        TreeNode unbalancedBST = new TreeNode(1);
        unbalancedBST.right = new TreeNode(2);
        unbalancedBST.right.right = new TreeNode(3);
        unbalancedBST.right.right.right = new TreeNode(4);
        
        System.out.println("平衡樹檢查：" + isBalanced(balancedBST));
        System.out.println("不平衡樹檢查：" + isBalanced(unbalancedBST));
        System.out.println("根節點平衡因子：" + getBalanceFactor(balancedBST));
        
        TreeNode mostUnbalanced = findMostUnbalancedNode(unbalancedBST);
        System.out.println("最不平衡節點值：" + (mostUnbalanced != null ? mostUnbalanced.val : "無"));
    }
}
