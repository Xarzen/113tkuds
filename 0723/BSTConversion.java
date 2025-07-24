import java.util.ArrayList;
import java.util.List;

public class BSTConversion {
    public static class TreeNode {
        int val;
        TreeNode left, right;
        TreeNode(int val) { this.val = val; }
    }
    
    public static class ListNode {
        int val;
        ListNode prev, next;
        ListNode(int val) { this.val = val; }
    }
    
    private static TreeNode prev = null;
    
    public static ListNode bstToDoublyLinkedList(TreeNode root) {
        if (root == null) return null;
        
        prev = null;
        TreeNode dummy = new TreeNode(0);
        prev = dummy;
        
        inorderConvert(root);
        
        ListNode head = new ListNode(dummy.right.val);
        TreeNode curr = dummy.right.right;
        ListNode listCurr = head;
        
        while (curr != null) {
            ListNode newNode = new ListNode(curr.val);
            listCurr.next = newNode;
            newNode.prev = listCurr;
            listCurr = newNode;
            curr = curr.right;
        }
        
        return head;
    }
    
    private static void inorderConvert(TreeNode node) {
        if (node == null) return;
        
        inorderConvert(node.left);
        
        prev.right = node;
        node.left = prev;
        prev = node;
        
        inorderConvert(node.right);
    }
    
    public static TreeNode sortedArrayToBST(int[] nums) {
        if (nums.length == 0) return null;
        return buildBST(nums, 0, nums.length - 1);
    }
    
    private static TreeNode buildBST(int[] nums, int left, int right) {
        if (left > right) return null;
        
        int mid = left + (right - left) / 2;
        TreeNode root = new TreeNode(nums[mid]);
        
        root.left = buildBST(nums, left, mid - 1);
        root.right = buildBST(nums, mid + 1, right);
        
        return root;
    }
    
    public static TreeNode convertBSTToGreaterSum(TreeNode root) {
        int[] sum = {0};
        reverseInorder(root, sum);
        return root;
    }
    
    private static void reverseInorder(TreeNode node, int[] sum) {
        if (node == null) return;
        
        reverseInorder(node.right, sum);
        
        sum[0] += node.val;
        node.val = sum[0];
        
        reverseInorder(node.left, sum);
    }
    
    public static List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        inorderHelper(root, result);
        return result;
    }
    
    private static void inorderHelper(TreeNode node, List<Integer> result) {
        if (node == null) return;
        inorderHelper(node.left, result);
        result.add(node.val);
        inorderHelper(node.right, result);
    }
    
    public static List<Integer> doublyListToArray(ListNode head) {
        List<Integer> result = new ArrayList<>();
        ListNode curr = head;
        while (curr != null) {
            result.add(curr.val);
            curr = curr.next;
        }
        return result;
    }
    
    public static void main(String[] args) {
        TreeNode bst = new TreeNode(4);
        bst.left = new TreeNode(2);
        bst.right = new TreeNode(6);
        bst.left.left = new TreeNode(1);
        bst.left.right = new TreeNode(3);
        bst.right.left = new TreeNode(5);
        bst.right.right = new TreeNode(7);
        
        System.out.println("原始BST中序遍歷：" + inorderTraversal(bst));
        
        ListNode doublyList = bstToDoublyLinkedList(bst);
        System.out.println("轉換為雙向鏈表：" + doublyListToArray(doublyList));
        
        int[] sortedArray = {1, 2, 3, 4, 5, 6, 7};
        TreeNode balancedBST = sortedArrayToBST(sortedArray);
        System.out.println("陣列轉BST：" + inorderTraversal(balancedBST));
        
        TreeNode bst2 = new TreeNode(4);
        bst2.left = new TreeNode(2);
        bst2.right = new TreeNode(6);
        bst2.left.left = new TreeNode(1);
        bst2.left.right = new TreeNode(3);
        bst2.right.left = new TreeNode(5);
        bst2.right.right = new TreeNode(7);
        
        convertBSTToGreaterSum(bst2);
        System.out.println("轉換為累加和：" + inorderTraversal(bst2));
    }
}
