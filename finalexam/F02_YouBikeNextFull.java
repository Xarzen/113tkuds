import java.util.Scanner;

public class F02_YouBikeNextFull {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        int n = scanner.nextInt();
        int[] times = new int[n];
        
        for (int i = 0; i < n; i++) {
            String timeStr = scanner.next();
            times[i] = timeToMinutes(timeStr);
        }
        
        String queryStr = scanner.next();
        int queryTime = timeToMinutes(queryStr);
        
        int index = binarySearch(times, queryTime);
        
        if (index == -1) {
            System.out.println("No bike");
        } else {
            System.out.println(minutesToTime(times[index]));
        }
        
        scanner.close();
    }
    
    private static int timeToMinutes(String time) {
        String[] parts = time.split(":");
        int hours = Integer.parseInt(parts[0]);
        int minutes = Integer.parseInt(parts[1]);
        return hours * 60 + minutes;
    }
    
    private static String minutesToTime(int minutes) {
        int hours = minutes / 60;
        int mins = minutes % 60;
        return String.format("%02d:%02d", hours, mins);
    }
    
    private static int binarySearch(int[] times, int queryTime) {
        int left = 0;
        int right = times.length - 1;
        int result = -1;
        
        while (left <= right) {
            int mid = left + (right - left) / 2;
            
            if (times[mid] > queryTime) {
                result = mid;
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        
        return result;
    }
}

/*
 * Time Complexity: O(log n)
 * 說明： - 輸入處理O(n)、時間轉換O(1)、二分搜尋O(log n)、結果輸出O(1)。
 * 雖然要讀入n筆時間資料，但查詢時用二分搜尋法快速找答案，每次都能砍掉一半選項。
 */
