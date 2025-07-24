public class FIBONACCISLOW {
    
    // 標準遞迴版本 - 效率很差
    public static int fibonacciSlow(int n) {
        if (n <= 1) return n;
        return fibonacciSlow(n - 1) + fibonacciSlow(n - 2);
    }
    // 時間複雜度：O(2^n) - 指數級成長！
    // 空間複雜度：O(n) - 遞迴深度
    
    // 記憶化版本 - 效率很好
    public static int fibonacciFast(int n, int[] memo) {
        if (n <= 1) return n;
        if (memo[n] != 0) return memo[n];
        memo[n] = fibonacciFast(n - 1, memo) + fibonacciFast(n - 2, memo);
        return memo[n];
    }
    // 時間複雜度：O(n) - 每個數字只計算一次
    // 空間複雜度：O(n) - 儲存計算結果
    
    public static void main(String[] args) {
        int n = 35;
        
        System.out.println("=== 費波納契數列複雜度比較 ===");
        System.out.printf("計算 fibonacci(%d):\n", n);
        
        long startTime = System.nanoTime();
        int slowResult = fibonacciSlow(n);
        long slowTime = System.nanoTime() - startTime;
        
        int[] memo = new int[n + 1];
        startTime = System.nanoTime();
        int fastResult = fibonacciFast(n, memo);
        long fastTime = System.nanoTime() - startTime;
        
        System.out.printf("標準遞迴: %d (耗時: %.2f ms)\n", 
                        slowResult, slowTime / 1_000_000.0);
        System.out.printf("記憶化版: %d (耗時: %.2f ms)\n", 
                        fastResult, fastTime / 1_000_000.0);
    }
}
