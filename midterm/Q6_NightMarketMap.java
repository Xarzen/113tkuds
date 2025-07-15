import java.util.Arrays;
import java.util.Scanner;
public class Q6_NightMarketMap {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        char[][] map = new char[10][10];
        for (char[] row : map) Arrays.fill(row, '#');
        System.out.println("請輸入攤位數:");
        int m = sc.nextInt();
        for (int i = 0; i < m; i++) {
            System.out.println("請輸入攤位座標:");
            int r = sc.nextInt(), c = sc.nextInt();
            if (r >= 0 && r < 10 && c >= 0 && c < 10) map[r][c] = '*';
        }
        for (char[] row : map) System.out.println(new String(row));
    }
}
