package LAB;

import java.util.Scanner;

public class P12TradeCommissions {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        String town = scan.nextLine();
        double sales = Double.parseDouble(scan.nextLine());
        double commission = 0;

        switch (town) {
            case "Sofia":
                if (sales >= 0 && sales <= 500) {
                    commission = (sales - (sales * 0.95));
                    System.out.printf("%.2f", commission);
                } else if (sales > 500 && sales <= 1000) {
                    commission = (sales - (sales * 0.93));
                    System.out.printf("%.2f", commission);
                } else if (sales > 1000 && sales <= 10000) {
                    commission = (sales - (sales * 0.92));
                    System.out.printf("%.2f", commission);
                } else if (sales > 10000) {
                    commission = (sales - (sales * 0.88));
                    System.out.printf("%.2f", commission);
                } else {
                    System.out.println("error");
                }
                break;
            case "Varna": {
                if (sales >= 0 && sales <= 500) {
                    commission = (sales - (sales * 0.955));
                    System.out.printf("%.2f", commission);
                } else if (sales > 500 && sales <= 1000) {
                    commission = (sales - (sales * 0.925));
                    System.out.printf("%.2f", commission);
                } else if (sales > 1000 && sales <= 10000) {
                    commission = (sales - (sales * 0.90));
                    System.out.printf("%.2f", commission);
                } else if (sales > 10000) {
                    commission = (sales - (sales * 0.87));
                    System.out.printf("%.2f", commission);
                } else {
                    System.out.println("error");
                }
                break;
                }
            case "Plovdiv": {
                if (sales >= 0 && sales <= 500) {
                    commission = (sales - (sales * 0.945));
                    System.out.printf("%.2f", commission);
                } else if (sales > 500 && sales <= 1000) {
                    commission = (sales - (sales * 0.92));
                    System.out.printf("%.2f", commission);
                } else if (sales > 1000 && sales <= 10000) {
                    commission = (sales - (sales * 0.88));
                    System.out.printf("%.2f", commission);
                } else if (sales > 10000) {
                    commission = (sales - (sales * 0.855));
                    System.out.printf("%.2f", commission);
                } else {
                    System.out.println("error");
                }
                break;
            }
            default: {
                System.out.println("error");
            }
        }
//                Град	0 ≤ s ≤ 500;	500 < s ≤ 1 000;     1 000 < s ≤ 10 000;  s > 10 000
        //        Sofia	    5%	            7%	                8%	                12%
//                Varna	    4.5%	        7.5%	            10%	                13%
//                Plovdiv	5.5%	        8%	                12%	                14.5%

    }
}
