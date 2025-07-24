import java.util.HashMap;
import java.util.Map;

public class TreeReconstruction {
    public static class TreeNode {
        int val;
        TreeNode left, right;
        TreeNode(int val) { this.val = val; }
    }
    
    public static TreeNode buildTreeFromPreAndIn(int[] preorder, int[] inorder) {
        if (preorder.length == 0 || inorder.length == 0) return null;
        
        Map<Integer, Integer> inorderMap = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) {
            inorderMap.put(inorder[i], i);
        }
        
        return buildPreIn(preorder, 0, preorder.length - 1, 
                         inorder, 0, inorder.length - 1, inorderMap);
    }
    
    private static TreeNode buildPreIn(int[] preorder, int preStart, int preEnd,
                                      int[] inorder, int inStart, int inEnd,
                                      Map<Integer, Integer> inorderMap) {
        if (preStart > preEnd || inStart > inEnd) return null;
        
        TreeNode root = new TreeNode(preorder[preStart]);
        int rootIndex = inorderMap.get(root.val);
        int leftSubtreeSize = rootIndex - inStart;
        
        root.left = buildPreIn(preorder, preStart + 1, preStart + leftSubtreeSize,
                              inorder, inStart, rootIndex - 1, inorderMap);
        root.right = buildPreIn(preorder, preStart + leftSubtreeSize + 1, preEnd,
                               inorder, rootIndex + 1, inEnd, inorderMap);
        
        return root;
    }
    
    public static TreeNode buildTreeFromPostAndIn(int[] postorder, int[] inorder) {
        if (postorder.length == 0 || inorder.length == 0) return null;
        
        Map<Integer, Integer> inorderMap = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) {
            inorderMap.put(inorder[i], i);
        }
        
        return buildPostIn(postorder, 0, postorder.length - 1,
                          inorder, 0, inorder.length - 1, inorderMap);
    }
    
    private static TreeNode buildPostIn(int[] postorder, int postStart, int postEnd,
                                       int[] inorder, int inStart, int inEnd,
                                       Map<Integer, Integer> inorderMap) {
        if (postStart > postEnd || inStart > inEnd) return null;
        
        TreeNode root = new TreeNode(postorder[postEnd]);
        int rootIndex = inorderMap.get(root.val);
        int leftSubtreeSize = rootIndex - inStart;
        
        root.left = buildPostIn(postorder, postStart, postStart + leftSubtreeSize - 1,
                               inorder, inStart, rootIndex - 1, inorderMap);
        root.right = buildPostIn(postorder, postStart + leftSubtreeSize, postEnd - 1,
                                inorder, rootIndex + 1, inEnd, inorderMap);
        
        return root;
    }
    
    public static boolean verifyReconstruction(TreeNode original, TreeNode reconstructed) {
        if (original == null && reconstructed == null) return true;
        if (original == null || reconstructed == null) return false;
        if (original.val != reconstructed.val) return false;
        
        return verifyReconstruction(original.left, reconstructed.left) &&
               verifyReconstruction(original.right, reconstructed.right);
    }
    
    public static void main(String[] args) {
        TreeNode original = new TreeNode(3);
        original.left = new TreeNode(9);
        original.right = new TreeNode(20);
        original.right.left = new TreeNode(15);
        original.right.right = new TreeNode(7);
        
        int[] preorder = {3, 9, 20, 15, 7};
        int[] inorder = {9, 3, 15, 20, 7};
        int[] postorder = {9, 15, 7, 20, 3};
        
        TreeNode tree1 = buildTreeFromPreAndIn(preorder, inorder);
        TreeNode tree2 = buildTreeFromPostAndIn(postorder, inorder);
        
        System.out.println("前序+中序重建驗證：" + verifyReconstruction(original, tree1));
        System.out.println("後序+中序重建驗證：" + verifyReconstruction(original, tree2));
    }
}
