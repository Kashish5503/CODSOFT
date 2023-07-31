import java.util.Scanner;

public class NumberGame {
    public static void main(String[] args) {
        int min = 0;
        int max = 200;
        int a = (int) (Math.random() * (max - min + 1) + min);
        System.out.println("A Random number between 0 and 200 is generated\nYou have 3 tries to guess it");

        Scanner sc = new Scanner(System.in);
        System.out.print("First guess: ");
        int g1 = sc.nextInt();

        if (g1 > 200) {
            System.out.println("invalid Input");
        } else {
        }

        if (g1 == a) {
            System.out.println("Your Guess was right");
        } else {
            System.out.println("Try again");
        }

        System.out.print("Second Guess: ");
        int g2 = sc.nextInt();
        if (g2 > 200) {
            System.out.println("Invalid output");
        } else {
        }

        if (g2 == a) {
            System.out.println("Your Guess was right");
        } else {
            System.out.println("Try Again\nLast Try");
        }

        System.out.print("Last Guess: ");
        int g3 = sc.nextInt();
        if (g3 > 200) {
            System.out.println("invalid Input");
        } else {
        }

        if (g3 == a) {
            System.out.println("Your Guess was right");
        } else {
            System.out.println("Game over");
        }

        System.out.println("Random number generated between " + min + " and " + max + " was: " + a);
    }
}