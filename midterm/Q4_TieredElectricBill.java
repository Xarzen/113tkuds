import java.util.Scanner;
public class Q4_TieredElectricBill {
    public static int calc(int kWh) {
        int bill = 0;
        int[] limits = {120, 330, 500, 700, 1000, Integer.MAX_VALUE};
        double[] rates = {1.68, 2.45, 3.70, 5.04, 6.24, 8.46};
        int prev = 0;
        for (int i = 0; i < limits.length; i++) {
            if (kWh > limits[i]) {
                bill += (limits[i] - prev) * rates[i];
                prev = limits[i];
            } else {
                bill += (kWh - prev) * rates[i];
                break;
            }
        }
        return (int)Math.round(bill);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("請輸入帳單數:");
        int n = sc.nextInt(), total = 0;
        int[] bills = new int[n];
        for (int i = 0; i < n; i++) {
            System.out.println("請輸入用電量:");
            int k = sc.nextInt();
            bills[i] = calc(k);
            total += bills[i];
            System.out.println("Bill: $" + bills[i]);
        }
        System.out.println("Total: $" + total);
        System.out.println("Average: $" + Math.round((double)total / n));
    }
}
/*
 * Time Complexity: O(n)
 * 說明：每筆資料常數時間內計算費用，總共處理 n 筆。
 */