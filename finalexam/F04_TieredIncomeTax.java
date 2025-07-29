import java.util.Scanner;

public class F04_TieredIncomeTax {
    private static final int[] BRACKETS = {590000, 1330000, 2660000, 4980000, Integer.MAX_VALUE};
    private static final double[] RATES = {0.05, 0.12, 0.20, 0.30, 0.40};
    private static final int[] CUMULATIVE_TAX = {0, 29500, 118300, 384300, 1080300};
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        int n = scanner.nextInt();
        int[] taxes = new int[n];
        
        for (int i = 0; i < n; i++) {
            int income = scanner.nextInt();
            taxes[i] = calculateTax(income);
            System.out.println("Tax: $" + taxes[i]);
        }
        
        int totalTax = 0;
        for (int tax : taxes) {
            totalTax += tax;
        }
        
        int averageTax = totalTax / n;
        System.out.println("Average: $" + averageTax);
        
        scanner.close();
    }
    
    private static int calculateTax(int income) {
        if (income <= 0) return 0;
        
        for (int i = 0; i < BRACKETS.length; i++) {
            if (income <= BRACKETS[i]) {
                if (i == 0) {
                    return (int) (income * RATES[i]);
                } else {
                    return CUMULATIVE_TAX[i] + (int) ((income - BRACKETS[i-1]) * RATES[i]);
                }
            }
        }
        
        return 0;
    }
}

/*
 * Time Complexity: O(n) n筆收入處理迴圈O(n)、每次稅額計算遍歷固定5個級距O(1)、總稅額累加O(n)
 * 說明：n筆收入處理迴圈O(n)、每次稅額計算遍歷固定5個級距O(1)、總稅額累加O(n)。
 * 處理n個人的收入，每個人的稅金計算都只要查5個固定級距所以很快，總時間就是人數乘以常數。
 */
