import java.util.Scanner;

public class F01_TMRTStopCounter {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        int n = scanner.nextInt();
        String[] stations = new String[n];
        
        for (int i = 0; i < n; i++) {
            stations[i] = scanner.next();
        }
        
        String start = scanner.next();
        String end = scanner.next();
        
        int startIndex = -1;
        int endIndex = -1;
        
        for (int i = 0; i < n; i++) {
            if (stations[i].equals(start)) {
                startIndex = i;
            }
            if (stations[i].equals(end)) {
                endIndex = i;
            }
        }
        
        if (startIndex == -1 || endIndex == -1) {
            System.out.println("Invalid");
        } else {
            int stationCount = Math.abs(startIndex - endIndex) + 1;
            System.out.println(stationCount);
        }
        
        scanner.close();
    }
}

/*
 * Time Complexity: O(n) 
 * 說明：輸入讀取O(n)、線性搜尋起終站索引O(n)、計算站數O(1)。
 * 程式需要從頭到尾掃一遍所有車站來找起點跟終點站在第幾個位置，所以時間跟車站數量成正比。
 */
