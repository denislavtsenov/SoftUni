package DataTypesAndVariables.Exercise;

import java.util.Scanner;

public class P03_Elevator {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int numberOfPeople = Integer.parseInt(scan.nextLine());
        int capacity = Integer.parseInt(scan.nextLine());

        int courses = (int) Math.ceil((double) numberOfPeople / capacity);
        System.out.print(courses);
    }
}
