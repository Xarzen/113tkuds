public class ArrayStatistics {
    public static void main(String[] args) {
        int[] arr = {5, 12, 8, 15, 7, 23, 18, 9, 14, 6};
        int sum = 0, max = arr[0], min = arr[0];
        int maxIndex = 0, minIndex = 0;
        int countAboveAvg = 0, evenCount = 0, oddCount = 0;

        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];
            if (arr[i] > max) {
                max = arr[i];
                maxIndex = i;
            }
            if (arr[i] < min) {
                min = arr[i];
                minIndex = i;
            }
        }

        double avg = (double) sum / arr.length;

        for (int num : arr) {
            if (num > avg) countAboveAvg++;
            if (num % 2 == 0) evenCount++;
            else oddCount++;
        }

        System.out.println("統計結果：");
        System.out.println("總和: " + sum);
        System.out.printf("平均: %.2f\n", avg);
        System.out.println("最大值: " + max + "（索引 " + maxIndex + "）");
        System.out.println("最小值: " + min + "（索引 " + minIndex + "）");
        System.out.println("大於平均值的數字個數: " + countAboveAvg);
        System.out.println("偶數個數: " + evenCount);
        System.out.println("奇數個數: " + oddCount);
    }
}
