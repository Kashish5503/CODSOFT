import java.util.Scanner;

class usersbankaccount {
    int balance = 1000000;

    void printdata() {
        System.out.println(+balance);
    }
}

class ATMmachine extends usersbankaccount {
    int withdraw, deposit;

    void getdatad() {
        Scanner s1 = new Scanner(System.in);
        deposit = s1.nextInt();
    }

    void getdataw() {
        Scanner s2 = new Scanner(System.in);
        withdraw = s2.nextInt();
    }

    void printdatad() {
        balance = balance + deposit;
        System.out.println("Deposit successful");
        System.out.println("Updated Balance: " + balance);
    }

    void printdataw() {
        if (balance >= withdraw) {
            balance = balance - withdraw;
            System.out.println("Withdraw Successful");
            System.out.println("Updated Balance: " + balance);
        } else {
            System.out.println("Insufficient Balance");
        }
    }

}

public class ATMInterface {
    public static void main(String[] args) {
        ATMmachine atm = new ATMmachine();
        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.println("ATM");
            System.out.println("Option 1: Deposit");
            System.out.println("Option 2: withdraw");
            System.out.println("Option 3: Check Balance");
            System.out.println("Choose 4 for EXIT");
            System.out.print("Choose the operation you want to perform:");
            int choice = sc.nextInt();
            System.out.println(" ");
            switch (choice) {
                case 1:
                    System.out.print("Enter money to be Deposit: ");
                    atm.getdatad();
                    atm.printdatad();
                    System.out.println(" ");
                    break;
                case 2:
                    System.out.print("Enter money to Withdraw: ");
                    atm.getdataw();
                    atm.printdataw();
                    System.out.println(" ");
                    break;
                case 3:
                    System.out.print("Current Balance: ");
                    atm.printdata();
                    System.out.println(" ");
                    break;
                case 4:
                    System.out.println("Exiting... ");
                    System.out.println(" ");
                    System.exit(0);
            }
        }
    }
}
