package domain;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;

public class Bank implements Subject {

    private ArrayList<Observer> observers;
    private ArrayList<Account> accounts;

    public Bank(){
        observers = new ArrayList<>();
        accounts = new ArrayList<>();
    }

    @Override
    public void registerObserver(Observer observer) {
        observers.add(observer);
    }

    @Override
    public void removeObserver(Observer observer) {
        observers.remove(observer);
    }

    @Override
    public void notifyObservers() {
        for (Observer o: observers) {
            o.update(accounts.get(accounts.size()-1));
        }
    }

    public void addAccount(Account account){
        accounts.add(account);
        dataChanged();
    }

    public void dataChanged(){
        notifyObservers();
    }
}
