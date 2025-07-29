import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

public class F11_BSTClosestValue {
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
        
        int target = scanner.nextInt();
        
        TreeNode root = buildTree(nodeValues);
        int closest = closestValue(root, target);
        
        System.out.println(closest);
        
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
    
    private static int closestValue(TreeNode root, int target) {
        int closest = root.val;
        
        while (root != null) {
            if (Math.abs(root.val - target) < Math.abs(closest - target) ||
                (Math.abs(root.val - target) == Math.abs(closest - target) && root.val < closest)) {
                closest = root.val;
            }
            
            if (target < root.val) {
                root = root.left;
            } else {
                root = root.right;
            }
        }
        
        return closest;
    }
}
