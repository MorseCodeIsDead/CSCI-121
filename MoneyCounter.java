import java.util.Scanner;

public class MoneyCounter {
    public static void main(String[] args) {
        double inputMoney;

        Scanner input = new Scanner (System.in);
        System.out.println("Enter the amount: ");
        inputMoney = input.nextDouble() * 100;

        double inputShekels = (int)inputMoney * 3.7549;
        int nowShekels = (int)inputShekels;

            int outputShekel;
            int fifty;
            int ten;
            int five;
            int one;

            fifty = nowShekels / 50;
            outputShekel = nowShekels % 50;

            ten = outputShekel / 10;
            outputShekel = outputShekel % 10;

            five = outputShekel / 5;
            outputShekel = outputShekel % 5;

            one = outputShekel;


        int nowMoney = (int)inputMoney;

            int outputMoney;
            int quarters;
            int dimes;
            int nickels;
            int pennies;

            quarters = nowMoney / 25; // how many quarters
            outputMoney = nowMoney % 25;

            dimes = outputMoney / 10; // how many dimes
            outputMoney = outputMoney % 10;

            nickels = outputMoney / 5; // how many nickels
            outputMoney = outputMoney % 5;

            pennies = outputMoney;

            System.out.println(quarters+ " quarters");
            System.out.println(dimes+ " dimes");
            System.out.println(nickels+ " nickels");
            System.out.println(pennies+ " pennies");

        double finalShekels = nowShekels;

        System.out.println("That's also equal to "+ finalShekels / 100+ " in shekels");
        System.out.println(fifty+ " 50 agorot");
        System.out.println(ten+ " 10 agorot");
        System.out.println(five+ " 5 agorot");
        System.out.println(one+ " 1 agorot");

    }
}
