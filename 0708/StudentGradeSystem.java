public class StudentGradeSystem {
    public static void main(String[] args) {
        int[] scores = {85, 92, 78, 96, 87, 73, 89, 94, 81, 88};
        char[] grades = new char[scores.length];
        int[] levelCount = new int[4]; // A, B, C, D
        int max = scores[0], min = scores[0], maxIdx = 0, minIdx = 0;
        int total = 0;

        for (int i = 0; i < scores.length; i++) {
            int s = scores[i];
            total += s;
            if (s > max) { max = s; maxIdx = i; }
            if (s < min) { min = s; minIdx = i; }

            if (s >= 90) { grades[i] = 'A'; levelCount[0]++; }
            else if (s >= 80) { grades[i] = 'B'; levelCount[1]++; }
            else if (s >= 70) { grades[i] = 'C'; levelCount[2]++; }
            else { grades[i] = 'D'; levelCount[3]++; }
        }

        double avg = (double) total / scores.length;
        int countAboveAvg = 0;
        for (int s : scores) if (s > avg) countAboveAvg++;

        System.out.println("=== 成績報告 ===");
        System.out.println("總分: " + total + "，平均: " + String.format("%.2f", avg));
        System.out.println("最高分: " + max + "（學生 " + maxIdx + "）");
        System.out.println("最低分: " + min + "（學生 " + minIdx + "）");
        System.out.println("A: " + levelCount[0] + " B: " + levelCount[1] +
                " C: " + levelCount[2] + " D: " + levelCount[3]);
        System.out.printf("高於平均者比例: %.2f%%\n", (double) countAboveAvg / scores.length * 100);
        System.out.println("-------- 詳細列表 --------");
        System.out.println("編號\t分數\t等級");
        for (int i = 0; i < scores.length; i++) {
            System.out.println(i + "\t" + scores[i] + "\t" + grades[i]);
        }
    }
}
