package Arrays.Lab;

import java.util.Scanner;

public class P04_ReverseArrayOfStrings {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        String values = scan.nextLine();
        String[] arr = values.split(" ");

        for (int i = 0; i < arr.length / 2; i++) {
            String temp = arr[i];
            arr[i] = arr[arr.length - 1 - i];
            arr[arr.length - 1 - i] = temp;

        }
        System.out.println(String.join(" ", arr));


        //  for (int i = arr.length - 1; i >=0; i--) {
        //    System.out.print(arr[i] +  " ");
    }
}

