import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

public class F09_BinaryTreeLeftView {
    static class TreeNode {
        int val;
        TreeNode left, right;
        TreeNode(int val) { this.val = val; }
    }
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        List<Integer> values = new ArrayList<>();
        String line = scanner.nextLine();
        String[] parts = line.split(" ");
        
        for (String part : parts) {
            if (part.equals("-1")) {
                values.add(null);
            } else {
                values.add(Integer.parseInt(part));
            }
        }
        
        TreeNode root = buildTree(values);
        List<Integer> leftView = getLeftView(root);
        
        System.out.print("LeftView:");
        for (int val : leftView) {
            System.out.print(" " + val);
        }
        System.out.println();
        
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
    
    private static List<Integer> getLeftView(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if (root == null) return result;
        
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        
        while (!queue.isEmpty()) {
            int levelSize = queue.size();
            
            for (int i = 0; i < levelSize; i++) {
                TreeNode node = queue.poll();
                
                if (i == 0) {
                    result.add(node.val);
                }
                
                if (node.left != null) {
                    queue.offer(node.left);
                }
                if (node.right != null) {
                    queue.offer(node.right);
                }
            }
        }
        
        return result;
    }
}
