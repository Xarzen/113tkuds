public class TreeComparison {
    public static class TreeNode {
        int val;
        TreeNode left, right;
        TreeNode(int val) { this.val = val; }
    }
    
    public static boolean isSameTree(TreeNode p, TreeNode q) {
        if (p == null && q == null) return true;
        if (p == null || q == null) return false;
        if (p.val != q.val) return false;
        
        return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
    }
    
    public static boolean isSubtree(TreeNode root, TreeNode subRoot) {
        if (root == null) return false;
        if (isSameTree(root, subRoot)) return true;
        
        return isSubtree(root.left, subRoot) || isSubtree(root.right, subRoot);
    }
    
    public static TreeNode findLargestCommonSubtree(TreeNode root1, TreeNode root2) {
        if (root1 == null || root2 == null) return null;
        
        TreeNode[] result = {null};
        int[] maxSize = {0};
        
        findCommonSubtree(root1, root2, result, maxSize);
        return result[0];
    }
    
    private static void findCommonSubtree(TreeNode root1, TreeNode root2, TreeNode[] result, int[] maxSize) {
        if (root1 == null || root2 == null) return;
        
        if (isSameTree(root1, root2)) {
            int size = getTreeSize(root1);
            if (size > maxSize[0]) {
                maxSize[0] = size;
                result[0] = copyTree(root1);
            }
        }
        
        findCommonSubtree(root1.left, root2, result, maxSize);
        findCommonSubtree(root1.right, root2, result, maxSize);
        findCommonSubtree(root1, root2.left, result, maxSize);
        findCommonSubtree(root1, root2.right, result, maxSize);
    }
    
    private static int getTreeSize(TreeNode node) {
        if (node == null) return 0;
        return 1 + getTreeSize(node.left) + getTreeSize(node.right);
    }
    
    private static TreeNode copyTree(TreeNode node) {
        if (node == null) return null;
        TreeNode copy = new TreeNode(node.val);
        copy.left = copyTree(node.left);
        copy.right = copyTree(node.right);
        return copy;
    }
    
    public static void main(String[] args) {
        TreeNode tree1 = new TreeNode(3);
        tree1.left = new TreeNode(4);
        tree1.right = new TreeNode(5);
        tree1.left.left = new TreeNode(1);
        tree1.left.right = new TreeNode(2);
        
        TreeNode tree2 = new TreeNode(3);
        tree2.left = new TreeNode(4);
        tree2.right = new TreeNode(5);
        tree2.left.left = new TreeNode(1);
        tree2.left.right = new TreeNode(2);
        
        TreeNode subtree = new TreeNode(4);
        subtree.left = new TreeNode(1);
        subtree.right = new TreeNode(2);
        
        System.out.println("兩樹是否相同：" + isSameTree(tree1, tree2));
        System.out.println("是否為子樹：" + isSubtree(tree1, subtree));
        
        TreeNode common = findLargestCommonSubtree(tree1, tree2);
        System.out.println("最大公共子樹存在：" + (common != null));
        if (common != null) {
            System.out.println("公共子樹大小：" + getTreeSize(common));
        }
    }
}
