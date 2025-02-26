import java.rmi.RemoteException;

public class AccountImpl implements Account {

  private BankManager bankManager;
  private Client      client;
  private long        balance;
  private String      accountNumber;

  // public constructor
  public AccountImpl ( 
      BankManager bankManager, 
      Client client, 
      String accountNumber) {
    this.bankManager = bankManager;
    this.client      = client;
    this.balance     = 0;
    this.accountNumber = accountNumber;
  }

  public void deposit(long amount) throws RemoteException{
    if (amount <= 0) {
        throw new RemoteException("Deposit amount must be positive.");
    }
    balance += amount;
  }

  public BankManager getBankManager() 
      throws RemoteException {
    return bankManager;
  }

  public Client getClient() 
      throws RemoteException {
    return client;
  }

  public long getBalance() 
      throws RemoteException {
    return balance;
  }

  public long getCash(long amount)
      throws NoCashAvailableException, RemoteException {
    if (amount > balance) {
      throw new NoCashAvailableException("Insufficient balance to withdraw " + amount);
    }
    balance = balance - amount;
    return amount;
  }
}   
