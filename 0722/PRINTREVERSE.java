public class PRINTREVERSE {
    
    public static class ListNode {
        int val;
        ListNode next;
        
        ListNode(int val) {
            this.val = val;
            this.next = null;
        }
    }
    
    public static void printReverse(ListNode head) {
        if (head == null) {
            return;
        }
        printReverse(head.next);
        System.out.print(head.val + " ");
    }
    
    public static void printForward(ListNode head) {
        ListNode current = head;
        while (current != null) {
            System.out.print(current.val + " ");
            current = current.next;
        }
    }
    
    public static void main(String[] args) {
        System.out.println("=== 鏈結串列反向列印 ===");
        
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);
        
        System.out.print("原始鏈結串列：");
        printForward(head);
        System.out.println();
        
        System.out.print("反向列印結果：");
        printReverse(head);
        System.out.println();
        
        System.out.println("\n測試單一節點：");
        ListNode single = new ListNode(10);
        System.out.print("原始鏈結串列：");
        printForward(single);
        System.out.println();
        System.out.print("反向列印結果：");
        printReverse(single);
        System.out.println();
        
        System.out.println("\n測試空串列：");
        System.out.print("原始鏈結串列：");
        printForward(null);
        System.out.println("(空)");
        System.out.print("反向列印結果：");
        printReverse(null);
        System.out.println("(空)");
        
        System.out.println("\n測試長串列：");
        ListNode longList = new ListNode(10);
        longList.next = new ListNode(20);
        longList.next.next = new ListNode(30);
        longList.next.next.next = new ListNode(40);
        longList.next.next.next.next = new ListNode(50);
        longList.next.next.next.next.next = new ListNode(60);
        
        System.out.print("原始鏈結串列：");
        printForward(longList);
        System.out.println();
        System.out.print("反向列印結果：");
        printReverse(longList);
        System.out.println();
    }
}
