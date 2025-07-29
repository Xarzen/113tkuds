import java.util.Scanner;

public class F06_ArraySecondLargest {
    static class Pair {
        int max;
        int second;
        
        Pair(int max, int second) {
            this.max = max;
            this.second = second;
        }
    }
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        int n = scanner.nextInt();
        int[] arr = new int[n];
        
        for (int i = 0; i < n; i++) {
            arr[i] = scanner.nextInt();
        }
        
        Pair result = findSecondLargest(arr, 0, n - 1);
        System.out.println("SecondMax: " + result.second);
        
        scanner.close();
    }
    
    private static Pair findSecondLargest(int[] arr, int left, int right) {
        if (left == right) {
            return new Pair(arr[left], Integer.MIN_VALUE);
        }
        
        if (right - left == 1) {
            if (arr[left] > arr[right]) {
                return new Pair(arr[left], arr[right]);
            } else {
                return new Pair(arr[right], arr[left]);
            }
        }
        
        int mid = left + (right - left) / 2;
        Pair leftPair = findSecondLargest(arr, left, mid);
        Pair rightPair = findSecondLargest(arr, mid + 1, right);
        
        return mergePairs(leftPair, rightPair);
    }
    
    private static Pair mergePairs(Pair left, Pair right) {
        if (left.max > right.max) {
            int secondMax = Math.max(left.second, right.max);
            return new Pair(left.max, secondMax);
        } else {
            int secondMax = Math.max(right.second, left.max);
            return new Pair(right.max, secondMax);
        }
    }
}

/*
 * Time Complexity: O(n) 
 * 說明：分治法遞歸樹深度O(log n)每層處理O(n)個元素、合併操作O(1)，根據主定理T(n)=2T(n/2)+O(1)。
 * 用分治法把陣列一直對半切找答案，雖然要切很多層但每個數字只會被看一次，所以總時間跟陣列大小成正比。
 */
