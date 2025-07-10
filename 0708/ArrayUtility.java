import java.util.Arrays;

public class ArrayUtility {
    public static void main(String[] args) {
        int[] arr = {3, 7, 1, 9, 4, 6, 8, 2, 5};

        printArray(arr);

        reverseArray(arr);
        System.out.print("反轉後: ");
        printArray(arr);

        int[] copy = copyArray(arr);
        System.out.print("副本: ");
        printArray(copy);

        int secondLargest = findSecondLargest(arr);
        System.out.println("第二大數值: " + secondLargest);
    }

    public static void printArray(int[] array) {
        System.out.println(Arrays.toString(array));
    }

    public static void reverseArray(int[] array) {
        for (int i = 0; i < array.length / 2; i++) {
            int temp = array[i];
            array[i] = array[array.length - 1 - i];
            array[array.length - 1 - i] = temp;
        }
    }

    public static int[] copyArray(int[] array) {
        return Arrays.copyOf(array, array.length);
    }

    public static int findSecondLargest(int[] array) {
        int max = Integer.MIN_VALUE, second = Integer.MIN_VALUE;
        for (int num : array) {
            if (num > max) {
                second = max;
                max = num;
            } else if (num > second && num != max) {
                second = num;
            }
        }
        return second;
    }
}
