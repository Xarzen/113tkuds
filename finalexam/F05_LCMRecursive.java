import java.util.Scanner;

public class F05_LCMRecursive {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        int a = scanner.nextInt();
        int b = scanner.nextInt();
        
        int gcd = gcd(a, b);
        long lcm = (long) a * b / gcd;
        
        System.out.println("LCM: " + lcm);
        
        scanner.close();
    }
    
    private static int gcd(int a, int b) {
        if (a == b) {
            return a;
        }
        
        if (a > b) {
            return gcd(a - b, b);
        } else {
            return gcd(a, b - a);
        }
    }
}

/*
 * Time Complexity: O(max(a,b)) 輾轉相減法遞歸呼叫次數取決於兩數差值，最壞情況如gcd(1,n)需進行n-1次減法
 * 說明：輾轉相減法遞歸呼叫次數取決於兩數差值，最壞情況如gcd(1,n)需進行n-1次減法。
 * 用相減法求最大公因數，最糟情況像gcd(1,100)要減99次，所以時間跟較大數字成正比。
 */
