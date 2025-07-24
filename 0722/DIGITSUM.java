public class DIGITSUM {
    
    public static int digitSum(int n) {
        if (n == 0) {
            return 0;
        }
        return n % 10 + digitSum(n / 10);
    }
    
    public static void main(String[] args) {
        System.out.println("=== 數字各位數總和 ===");
        
        int[] testCases = {
            123,
            456,
            789,
            1000,
            9999,
            1,
            0,
            5432,
            12345
        };
        
        for (int testCase : testCases) {
            int result = digitSum(testCase);
            System.out.printf("digitSum(%d) = %d\n", testCase, result);
        }
    }
}