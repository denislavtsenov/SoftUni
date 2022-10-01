package List.MidExams.ProgrammingFundamentalsMidExam05072020;

import java.util.Scanner;

public class P01_SoftUniReception {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int firstStudentsPerHour = Integer.parseInt(scanner.nextLine());
        int secondStudentsPerHour = Integer.parseInt(scanner.nextLine());
        int thirdStudentsPerHour = Integer.parseInt(scanner.nextLine());
        int studentsCount = Integer.parseInt(scanner.nextLine());

        int totalStudentsPerHour = firstStudentsPerHour + secondStudentsPerHour + thirdStudentsPerHour;

        int hour = 0;
        while (studentsCount > 0) {
            studentsCount -= totalStudentsPerHour;
            hour++;

            if (hour % 4 == 0) {
                hour++;
            }
        }
        System.out.printf("Time needed: %dh.", hour);
    }
}
