public class GCD {
    
    public static int gcd(int a, int b) {
        if (b == 0) {
            return a;
        }
        return gcd(b, a % b);
    }
    
    public static void main(String[] args) {
        System.out.println("=== 最大公因數計算 ===");
        
        int[][] testCases = {
            {48, 18},
            {56, 42},
            {17, 13},
            {100, 25},
            {0, 5},
            {7, 0}
        };
        
        for (int[] testCase : testCases) {
            int a = testCase[0];
            int b = testCase[1];
            int result = gcd(a, b);
            System.out.printf("gcd(%d, %d) = %d\n", a, b, result);
        }
    }
}
