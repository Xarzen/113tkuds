import java.util.Scanner;
public class Q1_THSRStopCounter {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("請輸入停靠站數:");
        int n = sc.nextInt();
        String[] stops = new String[n];
        System.out.println("請輸入停靠站:");
        for (int i = 0; i < n; i++) stops[i] = sc.next();
        System.out.println("請輸入起始站:");
        String start = sc.next(); 
        System.out.println("請輸入結束站:");
        String end = sc.next();
        int startIdx = -1, endIdx = -1;
        for (int i = 0; i < n; i++) {
            if (stops[i].equals(start)) startIdx = i;
            if (stops[i].equals(end)) endIdx = i;
        }
        if (startIdx == -1 || endIdx == -1) System.out.println("Invalid");
        else System.out.println(Math.abs(startIdx - endIdx) + 1);
    }
}
/*
 * Time Complexity: O(n)
 * 說明：使用一次陣列找起訖站。
 */