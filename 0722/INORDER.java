public class INORDER {
    
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
    
    public static void inOrder(TreeNode root) {
        if (root == null) {
            return;
        }
        inOrder(root.left);
        System.out.print(root.val + " ");
        inOrder(root.right);
    }
    
    public static void main(String[] args) {
        System.out.println("=== 二元樹中序走訪 ===");
        
        TreeNode root = new TreeNode(4);
        root.left = new TreeNode(2);
        root.right = new TreeNode(6);
        root.left.left = new TreeNode(1);
        root.left.right = new TreeNode(3);
        root.right.left = new TreeNode(5);
        root.right.right = new TreeNode(7);
        
        System.out.println("建立的二元樹結構：");
        System.out.println("        4");
        System.out.println("       / \\");
        System.out.println("      2   6");
        System.out.println("     / \\ / \\");
        System.out.println("    1  3 5  7");
        
        System.out.print("\n中序走訪結果：");
        inOrder(root);
        System.out.println();
        
        System.out.println("\n測試單一節點樹：");
        TreeNode singleNode = new TreeNode(10);
        System.out.print("中序走訪結果：");
        inOrder(singleNode);
        System.out.println();
        
        System.out.println("\n測試空樹：");
        System.out.print("中序走訪結果：");
        inOrder(null);
        System.out.println("(空)");
        
        System.out.println("\n測試不平衡樹：");
        TreeNode unbalanced = new TreeNode(1);
        unbalanced.right = new TreeNode(2);
        unbalanced.right.right = new TreeNode(3);
        System.out.print("中序走訪結果：");
        inOrder(unbalanced);
        System.out.println();
    }
}
