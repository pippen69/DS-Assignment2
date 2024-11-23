import java.io.IOException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.Scanner;

public class bankclient {

    @SuppressWarnings("resource")
    public static void main(String argv[]) {
        if(argv.length != 4) {
          System.exit(1);
        }

        Scanner sc = new Scanner (System.in);

        try {
           //host, and port from command line
           Registry registry = LocateRegistry.getRegistry("localhost", 5000);
            bankinterface bank = (bankinterface) registry.lookup("bankserver");
        
        


        //enter card number
        int cardnum;
        while (true){
        System.out.println("Please enter your 6 digit card number");
        cardnum = sc.nextInt();
        if (cardnum >= 100000 && cardnum <= 999999){
            System.out.println("Card Number OK");
            break;
        }
        else {
            System.out.println("Invalid input. Try Again");
        }
    }

    //int pin
    int pin;
    while (true){
        //enter your 4 digit password
        System.out.println("Please enter you 4 digit pin ");
        pin = sc.nextInt();
        if (pin >= 1000 && pin <=9999 ){
            System.out.println("Pin OK");
            break;
        }
        else {
            System.out.println("Invalid input. Try Again");
        }
    }  
       
        while (true){
      

        System.out.println("Please select the one of the following options: ");
        System.out.println("1. Deposit to Chequing");
        System.out.println("2. Withdraw from Chequing");
        System.out.println("3. Deposit to Savings");
        System.out.println("4. Withdraw from Savings");
        System.out.println("5 Check Balance");
        System.out.println("6. Exit");
        int option = sc.nextInt(); 
        String response = "";


        double amount = 0;
        switch (option){
            case 1:
                System.out.println("DEPOSIT TO CHEQUING\n");
                System.out.println("Amount you would like to deposit: ");
                amount = sc.nextDouble();
                //RMI call
                response = bank.request(option, amount);
                System.out.println(response);
            
            break; 

            case 2:
            System.out.println("WITHDRAW FROM CHEQUING\n");
            System.out.println("Amount you would like to withdraw: ");
            amount = sc.nextDouble();
            response = bank.request(option, amount);
            System.out.println(response);
            break; 

            case 3:
                System.out.println("DEPOSIT TO SAVINGS\n");
                System.out.println("Amount you would like to deposit: ");
                amount = sc.nextDouble();
                response = bank.request(option, amount);
                System.out.println(response);
            break; 

            case 4:
            System.out.println("WITHDRAW FROM SAVINGS\n");
            System.out.println("Amount you would like to withdraw: ");
            amount = sc.nextDouble();
            response = bank.request(option, amount);
            System.out.println(response);
            break; 

            case 5:
                System.out.println("CHECK BALANCE\n");
                response = bank.request(option, 0);
                System.out.println(response);
            
            break;

            case 6: 
                System.out.println("Thank you for using Bank of Zank. Exiting...");
            return;

           default:
                    System.out.println("Invalid option. Try Again.");
                }
            }
            //scanner.close();
        
        }catch (Exception e){
            e.printStackTrace();
        
        }

        
    }
}

