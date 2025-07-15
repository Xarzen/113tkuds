import java.util.Scanner;
public class Q2_NextTHSRDeparture {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("請輸入班次數:");
        int n = sc.nextInt();
        int[] times = new int[n];
        sc.nextLine();
        for (int i = 0; i < n; i++) {
            System.out.println("請輸入時間:");
            String[] t = sc.nextLine().split(":");
            times[i] = Integer.parseInt(t[0]) * 60 + Integer.parseInt(t[1]);
        }
        System.out.println("請輸入查詢時間:");
        String[] q = sc.nextLine().split(":");
        int query = Integer.parseInt(q[0]) * 60 + Integer.parseInt(q[1]);

        int l = 0, r = n - 1, ans = -1;
        while (l <= r) {
            int m = (l + r) / 2;
            if (times[m] > query) {
                ans = m;
                r = m - 1;
            } else l = m + 1;
        }

        if (ans == -1) System.out.println("No train");
        else System.out.printf("%02d:%02d\n", times[ans] / 60, times[ans] % 60);
    }
}
/*
 * Time Complexity: O(log n)
 * 說明：使用二元搜尋查找下一班車時間。
 */