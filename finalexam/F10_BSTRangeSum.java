import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

public class F10_BSTRangeSum {
    static class TreeNode {
        int val;
        TreeNode left, right;
        TreeNode(int val) { this.val = val; }
    }
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        String[] values = scanner.nextLine().split(" ");
        List<Integer> nodeValues = new ArrayList<>();
        for (String val : values) {
            if (!val.equals("-1")) {
                nodeValues.add(Integer.parseInt(val));
            } else {
                nodeValues.add(null);
            }
        }
        
        String[] range = scanner.nextLine().split(" ");
        int L = Integer.parseInt(range[0]);
        int R = Integer.parseInt(range[1]);
        
        TreeNode root = buildTree(nodeValues);
        int sum = rangeSumBST(root, L, R);
        
        System.out.println(sum);
        
        scanner.close();
    }
    
    private static TreeNode buildTree(List<Integer> values) {
        if (values.isEmpty() || values.get(0) == null) {
            return null;
        }
        
        TreeNode root = new TreeNode(values.get(0));
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        
        int i = 1;
        while (!queue.isEmpty() && i < values.size()) {
            TreeNode node = queue.poll();
            
            if (i < values.size() && values.get(i) != null) {
                node.left = new TreeNode(values.get(i));
                queue.offer(node.left);
            }
            i++;
            
            if (i < values.size() && values.get(i) != null) {
                node.right = new TreeNode(values.get(i));
                queue.offer(node.right);
            }
            i++;
        }
        
        return root;
    }
    
    private static int rangeSumBST(TreeNode root, int L, int R) {
        if (root == null) {
            return 0;
        }
        
        int sum = 0;
        
        if (root.val >= L && root.val <= R) {
            sum += root.val;
        }
        
        if (root.val > L) {
            sum += rangeSumBST(root.left, L, R);
        }
        
        if (root.val < R) {
            sum += rangeSumBST(root.right, L, R);
        }
        
        return sum;
    }
}
