public class TreeMirror {
    
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
    
    public static boolean isSymmetric(TreeNode root) {
        if (root == null) {
            return true;
        }
        return isMirror(root.left, root.right);
    }
    
    private static boolean isMirror(TreeNode left, TreeNode right) {
        if (left == null && right == null) {
            return true;
        }
        if (left == null || right == null) {
            return false;
        }
        return (left.val == right.val) && 
               isMirror(left.left, right.right) && 
               isMirror(left.right, right.left);
    }
    
    public static TreeNode mirror(TreeNode root) {
        if (root == null) {
            return null;
        }
        TreeNode temp = root.left;
        root.left = root.right;
        root.right = temp;
        mirror(root.left);
        mirror(root.right);
        return root;
    }
    
    public static boolean areMirrors(TreeNode tree1, TreeNode tree2) {
        return isMirror(tree1, tree2);
    }
    
    public static void inOrder(TreeNode root) {
        if (root == null) {
            return;
        }
        inOrder(root.left);
        System.out.print(root.val + " ");
        inOrder(root.right);
    }
    
    public static void preOrder(TreeNode root) {
        if (root == null) {
            return;
        }
        System.out.print(root.val + " ");
        preOrder(root.left);
        preOrder(root.right);
    }
    
    public static void main(String[] args) {
        System.out.println("=== 二元樹鏡像 ===");
        
        TreeNode symmetric = new TreeNode(1);
        symmetric.left = new TreeNode(2);
        symmetric.right = new TreeNode(2);
        symmetric.left.left = new TreeNode(3);
        symmetric.left.right = new TreeNode(4);
        symmetric.right.left = new TreeNode(4);
        symmetric.right.right = new TreeNode(3);
        
        System.out.println("對稱樹測試：");
        System.out.print("前序走訪：");
        preOrder(symmetric);
        System.out.println();
        System.out.println("是否對稱：" + isSymmetric(symmetric));
        
        TreeNode asymmetric = new TreeNode(1);
        asymmetric.left = new TreeNode(2);
        asymmetric.right = new TreeNode(2);
        asymmetric.left.right = new TreeNode(3);
        asymmetric.right.right = new TreeNode(3);
        
        System.out.println("\n非對稱樹測試：");
        System.out.print("前序走訪：");
        preOrder(asymmetric);
        System.out.println();
        System.out.println("是否對稱：" + isSymmetric(asymmetric));
        
        TreeNode original = new TreeNode(1);
        original.left = new TreeNode(2);
        original.right = new TreeNode(3);
        original.left.left = new TreeNode(4);
        original.left.right = new TreeNode(5);
        
        System.out.println("\n樹鏡像轉換測試：");
        System.out.print("原始樹前序走訪：");
        preOrder(original);
        System.out.println();
        
        mirror(original);
        System.out.print("鏡像後前序走訪：");
        preOrder(original);
        System.out.println();
        
        TreeNode tree1 = new TreeNode(1);
        tree1.left = new TreeNode(2);
        tree1.right = new TreeNode(3);
        
        TreeNode tree2 = new TreeNode(1);
        tree2.left = new TreeNode(3);
        tree2.right = new TreeNode(2);
        
        System.out.println("\n兩樹互為鏡像測試：");
        System.out.print("樹1前序走訪：");
        preOrder(tree1);
        System.out.println();
        System.out.print("樹2前序走訪：");
        preOrder(tree2);
        System.out.println();
        System.out.println("是否互為鏡像：" + areMirrors(tree1, tree2));
    }
}
