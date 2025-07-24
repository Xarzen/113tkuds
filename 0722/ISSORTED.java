public class ISSORTED {
    
    public static boolean isSorted(int[] arr, int index) {
        if (index >= arr.length - 1) {
            return true;
        }
        if (arr[index] > arr[index + 1]) {
            return false;
        }
        return isSorted(arr, index + 1);
    }
    
    public static void main(String[] args) {
        System.out.println("=== 檢查陣列排序 ===");
        
        int[][] testCases = {
            {1, 2, 3, 4, 5},
            {5, 4, 3, 2, 1},
            {1, 3, 2, 4, 5},
            {1},
            {},
            {1, 1, 2, 3, 3},
            {3, 2, 4, 1, 5}
        };
        
        for (int[] testCase : testCases) {
            boolean result = isSorted(testCase, 0);
            System.out.print("陣列 ");
            if (testCase.length == 0) {
                System.out.print("[]");
            } else {
                System.out.print("[");
                for (int i = 0; i < testCase.length; i++) {
                    System.out.print(testCase[i]);
                    if (i < testCase.length - 1) System.out.print(", ");
                }
                System.out.print("]");
            }
            System.out.println(" 是否已排序: " + result);
        }
    }
}