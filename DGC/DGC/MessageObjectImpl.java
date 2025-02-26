import java.io.Serializable;

public class MessageObjectImpl implements Serializable {
    private static final long serialVersionUID = 1L;  // Version de la classe pour la sérialisation
    
    static int number = 0;
    private int objNumber;

    public MessageObjectImpl() {
        objNumber = number;
        System.out.println("MessageObjectImpl: Class Number is #" + number + " Object Number is #" + objNumber);
        number++;
    }

    public int getNumberFromObject() {
        return objNumber;
    }

    public int getNumberFromClass() {
        return number;
    }
}
