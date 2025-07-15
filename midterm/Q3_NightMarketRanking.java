import java.util.Scanner;
public class Q3_NightMarketRanking {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("請輸入店家數:");
        int n = sc.nextInt();
        double[] scores = new double[n];
        System.out.println("請輸入評分:");
        for (int i = 0; i < n; i++) scores[i] = sc.nextDouble();

        for (int i = 0; i < n - 1; i++) {
            int maxIdx = i;
            for (int j = i + 1; j < n; j++) {
                if (scores[j] > scores[maxIdx]) maxIdx = j;
            }
            double temp = scores[i];
            scores[i] = scores[maxIdx];
            scores[maxIdx] = temp;
        }

        for (int i = 0; i < Math.min(5, n); i++)
            System.out.printf("%.1f\n", scores[i]);
    }
}
/*
 * Time Complexity: O(n^2)
 * 說明：用雙層迴圈進行比較與交換。
 */
