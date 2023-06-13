package esempi.observer;

import java.util.ArrayList;

public class ConnectionNotifier implements Observable{

    private ArrayList<Observer> observers = new ArrayList<>();

    public ArrayList<Observer> getObservers(){
        return observers;
    }

    @Override
    public void addObserver(Observer o) {
        observers.add(o);
    }

    @Override
    public void deleteObserver(Observer o) {
        observers.remove(o);
    }

    @Override
    public void notifyObservers(){
        for(Observer o : observers){
            o.notifiyMe(this, "OK");
        }
    }
}
