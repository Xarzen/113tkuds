import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
public class Q9_FindFiveStarStalls {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("請輸入攤位數:");
        int n = sc.nextInt();
        int[] a = new int[n];
        List<Integer> ans = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            System.out.println("請輸入評分:");
            a[i] = sc.nextInt();
            if (a[i] == 5) ans.add(i);
        }
        if (ans.isEmpty()) System.out.println("None");
        else for (int i : ans) System.out.print(i + " ");
    }
}