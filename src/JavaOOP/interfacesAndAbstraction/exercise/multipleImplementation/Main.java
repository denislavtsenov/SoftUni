package JavaOOP.interfacesAndAbstraction.exercise.multipleImplementation;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();
        List<Citizen> citizenList = new ArrayList<>();
        List<Pet> petList = new ArrayList<>();


        while (!"End".equals(input)) {
            String[] inputData = input.split("\\s+");
            String type = inputData[0];

            switch (type) {
                case "Citizen":
                    String name = inputData[1];
                    int age = Integer.parseInt(inputData[2]);
                    String id = inputData[3];
                    String birthDate = inputData[4];

                   Citizen citizen = new Citizen(name, age, id, birthDate);
                    citizenList.add(citizen);

                    break;
                case "Robot":

                    break;
                case "Pet":
                    String petName = inputData[1];
                    String petBirthDate = inputData[2];
                    Pet pet = new Pet(petName, petBirthDate);
                    petList.add(pet);
                    break;
            }
            input = scanner.nextLine();
        }

        String specificYear = scanner.nextLine();

        for (Citizen citizen : citizenList) {
            if (citizen.getBirthDate().endsWith(specificYear)) {
                System.out.println(citizen.getBirthDate());
            }
        }

        for (Pet pet : petList) {
            if (pet.getBirthDate().endsWith(specificYear)) {
                System.out.println(pet.getBirthDate());
            }
        }
    }
}
