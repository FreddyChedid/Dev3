
import java.io.Serializable;

public class MessageObject implements Serializable {
    private static final long serialVersionUID = 1L;
    
    static int number = 0;
    private int objNumber;

    public MessageObject() {
        objNumber = number;
        System.out.println("MessageObject: Class Number is #" + number + " Object Number is #" + objNumber);
        number++;
    }

    public int getNumberFromObject() {
        return objNumber;
    }

    public int getNumberFromClass() {
        return number;
    }
}
