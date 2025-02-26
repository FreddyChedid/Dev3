import java.io.IOException;
import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class BankSystemServer {

  // public No-argument constructor
  public BankSystemServer() {
  }

  public static void main(String args[]) {
    new BankSystemServer();

    BankManager bm = null;

    try {
      // Create a BankManager object
      bm = new BankManagerImpl();

      // Export it to RMI
      UnicastRemoteObject.exportObject( bm,0 );
    } catch (RemoteException remoteException) {
      System.err.println( 
        "Failure during object export to RMI: " + 
         remoteException);
    }

    // Register an external name for the service
    if (bm != null) {
        try {
            Naming.rebind("//localhost/BankSystem", bm);
            System.out.println("Server started and bound to RMI registry.");
        } catch (RemoteException remoteException) {
            System.err.println("Failure during Name registration (RemoteException): " + remoteException.getMessage());
            remoteException.printStackTrace();
        } catch (MalformedURLException malformedException) {
            System.err.println("Failure during Name registration (MalformedURLException): " + malformedException.getMessage());
            malformedException.printStackTrace();
        } catch (Exception e) {
            System.err.println("Unexpected error during Name registration: " + e.getMessage());
            e.printStackTrace();
        }
    } else {
        System.err.println("Error: BankManager instance is null. Cannot bind to RMI registry.");
    }


    System.out.println("Server started.");
    System.out.println("Enter <CR> to end.");
    try {
       int i = System.in.read();
    } catch (IOException ioException) {
    }
    System.exit(0);
  }
}

