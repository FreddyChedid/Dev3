
import java.rmi.*;
import java.rmi.server.*;

public class HelloImpl extends UnicastRemoteObject 
implements Hello, Unreferenced
{

   public HelloImpl() throws RemoteException
   {
      super();
   }

   public String sayHello() throws RemoteException
   {
     return "Hello!";

   }

   public MessageObject getMessageObject() throws RemoteException {
    return new MessageObject();
}


   public void unreferenced()
   {
      System.out.println( "HelloImpl: Unreferenced" );
   }

}
