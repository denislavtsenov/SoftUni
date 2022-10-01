package ExercisesFromAllJavaBasic.ConditionalStatementsMoreExercises;

import java.util.Scanner;

public class P08FuelTankPart2 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        String type = scan.nextLine();
        double litres = Double.parseDouble(scan.nextLine());
        String discount = scan.nextLine();

        double totalSumGasoline = litres * 2.22;
        double totalSumDiesel = litres * 2.33;
        double totalSumGas = litres * 0.93;

        double SumGasolineWithDisc = totalSumGasoline - (litres * 0.18);
        double SumDieselWithDisc = totalSumDiesel - (litres * 0.12);
        double SumGasWithDisc = totalSumGas - (litres * 0.08);

        double totalSum = 0;

        if (litres >= 20 && litres <= 25) {
            if (discount.equals("Yes")) {
                if (type.equals("Gasoline")) {
                    totalSum = SumGasolineWithDisc * 0.92;
                } else if (type.equals("Diesel")) {
                    totalSum = SumDieselWithDisc * 0.92;
                } else if (type.equals("Gas")) {
                    totalSum = SumGasWithDisc * 0.92;
                }
            } else if (discount.equals("No")) {
                if (type.equals("Gasoline")) {
                    totalSum = totalSumGasoline * 0.92;
                } else if (type.equals("Diesel")) {
                    totalSum = totalSumDiesel * 0.92;
                } else if (type.equals("Gas")) {
                    totalSum = totalSumGas * 0.92;
                }
            }
        } else if (litres > 25) {
            if (discount.equals("Yes")) {
                if (type.equals("Gasoline")) {
                    totalSum = SumGasolineWithDisc * 0.90;
                } else if (type.equals("Diesel")) {
                    totalSum = SumDieselWithDisc * 0.90;
                } else if (type.equals("Gas")) {
                    totalSum = SumGasWithDisc * 0.90;
                }
            } else if (discount.equals("No")) {
                if (type.equals("Gasoline")) {
                    totalSum = totalSumGasoline * 0.90;
                } else if (type.equals("Diesel")) {
                    totalSum = totalSumDiesel * 0.90;
                } else if (type.equals("Gas")) {
                    totalSum = totalSumGas * 0.90;
                }
            }
        } else {
            if (discount.equals("Yes")) {
                if (type.equals("Gasoline")) {
                    totalSum = SumGasolineWithDisc;
                } else if (type.equals("Diesel")) {
                    totalSum = SumDieselWithDisc;
                } else if (type.equals("Gas")) {
                    totalSum = SumGasWithDisc;
                }
            } else if (discount.equals("No")) {
                if (type.equals("Gasoline")) {
                    totalSum = totalSumGasoline;
                } else if (type.equals("Diesel")) {
                    totalSum = totalSumDiesel;
                } else if (type.equals("Gas")) {
                    totalSum = totalSumGas;
                }

            }

        }
        System.out.printf("%.2f lv.", totalSum);
    }
}
