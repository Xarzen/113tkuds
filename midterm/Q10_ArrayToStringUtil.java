import java.util.Scanner;
public class Q10_ArrayToStringUtil {
    public static String arrayToString(int[] a) {
        if (a == null) return "null";
        if (a.length == 0) return "[]";
        StringBuilder sb = new StringBuilder("[");
        for (int i = 0; i < a.length; i++) {
            sb.append(a[i]);
            if (i < a.length - 1) sb.append(", ");
        }
        sb.append("]");
        return sb.toString();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; i++) a[i] = sc.nextInt();
        System.out.println(arrayToString(a));
    }
}
