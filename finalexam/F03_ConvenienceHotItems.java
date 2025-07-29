import java.util.Scanner;

public class F03_ConvenienceHotItems {
    static class Item {
        String name;
        int qty;
        
        Item(String name, int qty) {
            this.name = name;
            this.qty = qty;
        }
    }
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        int n = scanner.nextInt();
        Item[] items = new Item[n];
        
        for (int i = 0; i < n; i++) {
            String name = scanner.next();
            int qty = scanner.nextInt();
            items[i] = new Item(name, qty);
        }
        
        insertionSort(items);
        
        int displayCount = Math.min(10, n);
        for (int i = 0; i < displayCount; i++) {
            System.out.println("[" + items[i].name + ", " + items[i].qty + "]");
        }
        
        scanner.close();
    }
    
    private static void insertionSort(Item[] items) {
        for (int i = 1; i < items.length; i++) {
            Item key = items[i];
            int j = i - 1;
            
            while (j >= 0 && items[j].qty < key.qty) {
                items[j + 1] = items[j];
                j--;
            }
            items[j + 1] = key;
        }
    }
}

/*
 * Time Complexity: O(n²) 輸入讀取O(n)、插入排序外層迴圈O(n)內層最壞情況O(n)、輸出前10項O(1)
 * 說明：輸入讀取O(n)、插入排序外層迴圈O(n)內層最壞情況O(n)、輸出前10項O(1)。
 * 用插入排序法排商品銷量，每個商品都要跟前面已排好的商品一個個比較找位置插入。
 */
