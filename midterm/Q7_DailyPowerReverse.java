import java.util.Arrays;
import java.util.Scanner;
public class Q7_DailyPowerReverse {
    public static void reverseArray(int[] array) {
        int left=0;
        int right=array.length-1;
        while (left<right) {
            int temp=array[left];
            array[left]=array[right];
            array[right]=temp;
            left++;
            right--;
        }
    }
    public static void printArray(int[] array) {
        System.out.println(Arrays.toString(array));
    }
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        int[] a=new int[7];
        System.out.println("請輸入七個整數:");
        for (int i = 0; i < 7; i++) {
            a[i]=scanner.nextInt();
        }
        reverseArray(a);
        printArray(a);
    }
}