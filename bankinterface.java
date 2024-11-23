import java.rmi.Remote;
import java.rmi.RemoteException;

public interface bankinterface extends Remote {
        String request (int option, double amount) throws RemoteException;
        String DC (double amount) throws RemoteException;
        String WC (double amount) throws RemoteException;
        String DS (double amount) throws RemoteException;
        String WS (double amount) throws RemoteException;
      




    
}
