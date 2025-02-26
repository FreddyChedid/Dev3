import java.rmi.*;
import java.rmi.registry.*;
import java.rmi.server.*;

public class HelloServer {
    public static void main(String[] args) {
        try {
            byte pattern = (byte) 0xAC;

            // Start RMI registry if not already running
            try {
                LocateRegistry.createRegistry(2002);
                System.out.println("RMI Registry started on port 2002.");
            } catch (RemoteException e) {
                System.out.println("RMI Registry already running.");
            }

            // Create remote object and export it using custom sockets
            HelloImpl obj = new HelloImpl();
            RMIClientSocketFactory csf = new XorClientSocketFactory(pattern);
            RMIServerSocketFactory ssf = new XorServerSocketFactory(pattern);
            Hello stub = (Hello) UnicastRemoteObject.exportObject(obj, 0, csf, ssf);

            // Get or create registry and bind remote object
            Registry registry = LocateRegistry.getRegistry(2002);
            registry.rebind("Hello", stub);

            System.out.println("HelloServer is running...");

        } catch (Exception e) {
            System.err.println("Server exception: " + e.getMessage());
            e.printStackTrace();
        }
    }
}
