package esempi.observer;

public class Main {

    public static void main(String[] args){
        System.out.println("*****");

        ConnectionNotifier conn_notifier = new ConnectionNotifier();
        User2Notify user = new User2Notify("Davide", "Fella", conn_notifier);

        System.out.println(conn_notifier.getObservers());

    }
}
