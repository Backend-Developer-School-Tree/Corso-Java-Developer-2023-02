package esempi.observer;

public class User2Notify implements Observer {

    private String name;
    private String lastname;


    public User2Notify(String name, String lastname, ConnectionNotifier c) {
        this.name = name;
        this.lastname = lastname;
        c.addObserver(this);
    }

    @Override
    public void notifiyMe(Observable o, String message) {
        if (message.contains("OK")) {
            System.out.println("connessione stabilita");
        }
    }

    @Override
    public String toString() {
        return "User2Notify{" +
                "name='" + name + '\'' +
                ", lastname='" + lastname + '\'' +
                '}';
    }
}
