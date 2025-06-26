public class ds_05 {
    public static void main(String[] args) {
        int[] numbers = {3, 7, 2, 9, 1, 4, 6, 8, 5, 10};
        int sum = 0;

        for (int num : numbers) {
            sum += num;
        }

        System.out.println("陣列總和為：" + sum);
    }
}
