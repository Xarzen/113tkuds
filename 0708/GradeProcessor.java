public class GradeProcessor {
    public static void main(String[] args) {
        int[] scores = {78, 85, 92, 67, 88, 95, 73, 90};
        int total = 0;
        int max = scores[0], min = scores[0], maxIndex = 0, minIndex = 0;

        for (int i = 0; i < scores.length; i++) {
            total += scores[i];
            if (scores[i] > max) {
                max = scores[i];
                maxIndex = i;
            }
            if (scores[i] < min) {
                min = scores[i];
                minIndex = i;
            }
        }

        double avg = (double) total / scores.length;
        int countAboveAvg = 0;
        for (int score : scores) {
            if (score > avg) countAboveAvg++;
        }

        System.out.printf("總分: %d\n平均: %.2f\n", total, avg);
        System.out.println("最高分: " + max + "（索引 " + maxIndex + "）");
        System.out.println("最低分: " + min + "（索引 " + minIndex + "）");
        System.out.println("成績高於平均人數: " + countAboveAvg);

        for (int i = 0; i < scores.length; i++) {
            System.out.println("學生編號 " + i + ": " + scores[i]);
        }
    }
}
