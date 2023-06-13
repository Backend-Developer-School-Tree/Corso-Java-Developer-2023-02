package esempi.dep_injection;

public class Main {

    public static void main(String[] args){
        MessageService emailService = new EmailService();

        NotificationService notificationService = new NotificationService(emailService);
        notificationService.sendNotification("Ciao, messaggio di test!");
    }
}
