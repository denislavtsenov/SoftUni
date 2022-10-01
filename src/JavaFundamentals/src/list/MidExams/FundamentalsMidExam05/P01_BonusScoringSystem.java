package List.MidExams.FundamentalsMidExam05;

import java.util.Scanner;

public class P01_BonusScoringSystem {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int numOfStudents = Integer.parseInt(scanner.nextLine());
        int numOfLectures = Integer.parseInt(scanner.nextLine());
        int bonus = Integer.parseInt(scanner.nextLine());

        double maxBonusPoints = 0;
        double totalStudentAttendance = 0;
        double totalBonus = 0;

        for (int i = 0; i < numOfStudents; i++) {
            double attendance = Integer.parseInt(scanner.nextLine());

         totalBonus = attendance /numOfLectures * (5 + bonus);

            if (totalBonus > maxBonusPoints) {
                maxBonusPoints = totalBonus;
                totalStudentAttendance = attendance;
            }
        }

        System.out.printf("Max Bonus: %.0f.%n", Math.ceil(maxBonusPoints));
        System.out.printf("The student has attended %.0f lectures.", totalStudentAttendance);
    }

}

