import java.util.Scanner;

public class F07_AnagramPalindrome {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        String input = scanner.nextLine();
        
        if (canFormPalindrome(input)) {
            System.out.println("Possible");
        } else {
            System.out.println("Impossible");
        }
        
        scanner.close();
    }
    
    private static boolean canFormPalindrome(String str) {
        int[] freq = new int[26];
        
        for (char c : str.toCharArray()) {
            if (Character.isLetter(c)) {
                char lower = Character.toLowerCase(c);
                freq[lower - 'a']++;
            }
        }
        
        int oddCount = 0;
        for (int count : freq) {
            if (count % 2 == 1) {
                oddCount++;
            }
        }
        
        return oddCount <= 1;
    }
}
