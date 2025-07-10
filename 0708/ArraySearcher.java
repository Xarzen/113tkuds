public class ArraySearcher {
    public static void main(String[] args) {
        int[] arr = {12, 45, 23, 67, 34, 89, 56, 78, 91, 25};

        System.out.println("搜尋67，索引: " + findElement(arr, 67));
        System.out.println("搜尋100，索引: " + findElement(arr, 100));
        System.out.println("67出現次數: " + countOccurrences(arr, 67));
        System.out.println("100出現次數: " + countOccurrences(arr, 100));
    }

    public static int findElement(int[] array, int target) {
        for (int i = 0; i < array.length; i++) {
            if (array[i] == target) return i;
        }
        return -1;
    }

    public static int countOccurrences(int[] array, int target) {
        int count = 0;
        for (int num : array) {
            if (num == target) count++;
        }
        return count;
    }
}
