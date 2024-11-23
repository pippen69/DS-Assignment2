import java.rmi.*;
import java.rmi.registry.Registry;
import java.rmi.registry.LocateRegistry;
import java.rmi.server.RemoteServer;
import java.rmi.server.UnicastRemoteObject;

public class bankserver extends UnicastRemoteObject implements bankinterface{

    static double CB = 100; //chequing balance
    static double SB = 100; //savings balance
   
 

    public bankserver() throws RemoteException{
        super();
    }

    String response; 
              public String request (int option, double amount) throws RemoteException{
                switch (option){
                    case 1: 
                    System.out.println("DEPOSIT CHEQUING");

                    if (amount > 0 ){
                        CB += amount;
                        response = ("Successfuly depostied $"+amount+" to CHEQUING.\n");
                        System.out.println("New CHEQUING BALANCE: $"+CB);
                        System.out.println("Task Completed!");
                        
                    }
                    else {
                       System.out.println("Invalid deposit amount");
                    }
                
                    break;

                    case 2: 
                    System.out.println("WITHDRAW CHEQUING");


                    if (amount <= CB && amount > 0 ){
                        CB -= amount;
                        response = ("Successfuly withdrawed $"+amount+" from CHEQUING.\n");
                        System.out.println("New CHEQUING BALANCE: $"+CB);
                    }
                    else {
                        System.out.println("Invalid withdraw amount");
                    }
                    break;

                    case 3: 
                    System.out.println("DEPOSIT SAVINGS");
                    if (amount > 0 ){
                        SB += amount;
                        response=("Successfuly depostied $"+amount+" to SAVINGS.\n");
                        System.out.println("New SAVINGS BALANCE: $"+SB);
                    }
                    else {
                        System.out.println("Invalid deposit amount");
                    }
                    
                    break;

                    case 4: 
                    System.out.println("WITHDRAW SAVINGS");
                    
                    if (amount <=SB && amount > 0 ){
                        SB -= amount;
                        response = ("Successfuly withdrawed $"+amount+" from CHEQUING.\n");
                        System.out.println("New SAVINGS BALANCE: $"+SB);
                    }
                    else {
                        System.out.println("Invalid deposit amount");
                    }
                    break;

                    case 5:
                    System.out.println ("CHECK BALANCE");
                    
                    System.out.println("CHEQUING BALANCE: $ "+CB);
                    System.out.println("SAVINGS BALANCE: $ "+SB);

                    break;

                    case 6: 
                    System.out.println ("Exit");

                    default: 
                    System.out.println("Inavlid Option");

                    }
                        return response; 
                }

                public String DC (double amount) throws RemoteException{
                    return request(1, amount);
                }
                public String WC (double amount) throws RemoteException{
                    return request(2, amount);
                }
                public String DS (double amount) throws RemoteException{
                    return request(3, amount);
                }
                public String WS (double amount) throws RemoteException{
                    return request(4, amount);
                }

              public static void main(String argv[]){
               
                try { 
                    int portNumber = 5000;

                    bankserver bserver = new bankserver();
                    Registry registry = LocateRegistry.createRegistry(portNumber); 
                    registry.rebind("bankserver", bserver);

                    System.out.println("Bank of Zank is running...");


                } catch(Exception e){
                    e.printStackTrace();
                }

              }
              

            }

        

    
