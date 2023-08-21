package Number_Game;

import java.util.Scanner;

public class Number_Game {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Start the game:");
        System.out.println("Press S and Enter to start");
        String str = sc.next();
        int num = (int) (Math.random() * 100);
        System.out.println(num);

        do {
            System.out.println("Enter your number");
            int i = sc.nextInt();
            if (i < num) {
                System.out.println("Required number is greater");
                System.out.println("Try again");
            } else if (i == num) {
                break;
            } else {
                System.out.println("Required number is smaller");
                System.out.println("Try again");
            }

        } while (num > 0);

        System.out.println("Correct guess");
        System.out.println("Play again");

    }
}
