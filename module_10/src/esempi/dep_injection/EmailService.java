package esempi.dep_injection;

public class EmailService implements MessageService {

    public void sendMessage(String message){
        System.out.println("Inviando una email..");

        System.out.println(message);
    }
}
