public class matrix_multiplication_trace {
    public static void main(String[] args) {
        int[][] a = {{1, 2}, {3, 4}};
        int[][] b = {{5, 6}, {7, 8}};
        int[][] c = new int[2][2];

        for (int i = 0; i < 2; i++) {         
            for (int j = 0; j < 2; j++) {   
                System.out.print("計算位置 c[" + i + "][" + j + "]：");
                int sum = 0;
                for (int k = 0; k < 2; k++) {
                    int product = a[i][k] * b[k][j];
                    System.out.print(a[i][k] + "*" + b[k][j]);
                    sum += product;
                    if (k < 1) System.out.print(" + ");
                }
                c[i][j] = sum;
                System.out.println(" = " + c[i][j]);
            }
        }

        System.out.println("結果矩陣：");
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 2; j++) {
                System.out.print(c[i][j] + " ");
            }
            System.out.println();
        }
    }
}
