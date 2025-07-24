public class TreeStatistics {
    
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
    
    public static int sum(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return root.val + sum(root.left) + sum(root.right);
    }
    
    public static int findMax(TreeNode root) {
        if (root == null) {
            return Integer.MIN_VALUE;
        }
        int leftMax = findMax(root.left);
        int rightMax = findMax(root.right);
        return Math.max(root.val, Math.max(leftMax, rightMax));
    }
    
    public static int findMin(TreeNode root) {
        if (root == null) {
            return Integer.MAX_VALUE;
        }
        int leftMin = findMin(root.left);
        int rightMin = findMin(root.right);
        return Math.min(root.val, Math.min(leftMin, rightMin));
    }
    
    public static int countLeaves(TreeNode root) {
        if (root == null) {
            return 0;
        }
        if (root.left == null && root.right == null) {
            return 1;
        }
        return countLeaves(root.left) + countLeaves(root.right);
    }
    
    public static int depth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int leftDepth = depth(root.left);
        int rightDepth = depth(root.right);
        return 1 + Math.max(leftDepth, rightDepth);
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
        System.out.println("=== 二元樹基本統計 ===");
        
        TreeNode root = new TreeNode(10);
        root.left = new TreeNode(5);
        root.right = new TreeNode(15);
        root.left.left = new TreeNode(3);
        root.left.right = new TreeNode(7);
        root.right.left = new TreeNode(12);
        root.right.right = new TreeNode(20);
        root.left.left.left = new TreeNode(1);
        root.right.right.right = new TreeNode(25);
        
        System.out.println("樹結構（中序走訪）：");
        System.out.print("節點值：");
        inOrder(root);
        System.out.println();
        
        System.out.println("\n=== 統計結果 ===");
        System.out.println("所有節點值的總和：" + sum(root));
        System.out.println("最大值：" + findMax(root));
        System.out.println("最小值：" + findMin(root));
        System.out.println("葉節點數量：" + countLeaves(root));
        System.out.println("樹的深度：" + depth(root));
        
        System.out.println("\n=== 測試空樹 ===");
        TreeNode emptyTree = null;
        System.out.println("空樹的總和：" + sum(emptyTree));
        System.out.println("空樹的葉節點數量：" + countLeaves(emptyTree));
        System.out.println("空樹的深度：" + depth(emptyTree));
        
        System.out.println("\n=== 測試單一節點樹 ===");
        TreeNode singleNode = new TreeNode(42);
        System.out.println("單一節點的總和：" + sum(singleNode));
        System.out.println("單一節點的最大值：" + findMax(singleNode));
        System.out.println("單一節點的最小值：" + findMin(singleNode));
        System.out.println("單一節點的葉節點數量：" + countLeaves(singleNode));
        System.out.println("單一節點的深度：" + depth(singleNode));
    }
}
