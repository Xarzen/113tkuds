import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

public class F12_TreeDiameter {
    static class TreeNode {
        int val;
        TreeNode left, right;
        TreeNode(int val) { this.val = val; }
    }
    
    private static int maxDiameter = 0;
    
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
        
        TreeNode root = buildTree(nodeValues);
        maxDiameter = 0;
        calculateHeight(root);
        
        System.out.println(maxDiameter);
        
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
    
    private static int calculateHeight(TreeNode root) {
        if (root == null) {
            return 0;
        }
        
        int leftHeight = calculateHeight(root.left);
        int rightHeight = calculateHeight(root.right);
        
        int currentDiameter = leftHeight + rightHeight;
        maxDiameter = Math.max(maxDiameter, currentDiameter);
        
        return Math.max(leftHeight, rightHeight) + 1;
    }
}
