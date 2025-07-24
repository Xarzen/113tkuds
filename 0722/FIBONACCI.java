public class FIBONACCI {
    
    public static int fibonacci(int n) {
        if (n <= 1) {
            return n;
        }
        return fibonacci(n - 1) + fibonacci(n - 2);
    }
    
    public static void main(String[] args) {
        System.out.println("=== 費波納契數列 ===");
        
        int[] testCases = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        
        for (int testCase : testCases) {
            int result = fibonacci(testCase);
            System.out.printf("fibonacci(%d) = %d\n", testCase, result);
        }
        
        System.out.println("\n費波納契數列前11項: ");
        for (int i = 0; i <= 10; i++) {
            System.out.print(fibonacci(i));
            if (i < 10) System.out.print(", ");
        }
        System.out.println();
    }
}
