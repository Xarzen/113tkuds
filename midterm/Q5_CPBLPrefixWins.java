import java.util.Scanner;
public class Q5_CPBLPrefixWins {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("請輸入場數:");
        int n = sc.nextInt();
        int[] a = new int[n];
        System.out.println("請輸入勝敗:");
        for (int i = 0; i < n; i++) a[i] = sc.nextInt();
        System.out.println("請輸入查詢數:");
        int k = sc.nextInt();
        int[] ps = new int[n + 1];
        for (int i = 1; i <= n; i++) ps[i] = ps[i - 1] + a[i - 1];
        System.out.print("PrefixSum:");
        for (int i = 1; i <= k; i++) System.out.print(" " + ps[i]);
        System.out.println();
    }
}
/*
 * Time Complexity: O(n)
 * 說明：輸入資料O(n)因為一次迴圈讀取n個勝敗結果，計算前綴和O(n)因為一次迴圈累加n個元素，
 * 輸出前k個結果O(k)因為固定輸出k次。因此整體由前綴和計算的O(n)主導。
 */