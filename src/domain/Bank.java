package domain;

import java.util.ArrayList;
import java.util.HashMap;

public class Bank implements Subject {

    private HashMap<EventTypeEnum,ArrayList<Observer>> observers;
    private ArrayList<Account> accounts;

    public Bank(){
        observers = new HashMap<>();
        for (EventTypeEnum e: EventTypeEnum.values()) {
            observers.put(e,new ArrayList<>());
        }
        accounts = new ArrayList<>();
    }

    @Override
    public void registerObserver(EventTypeEnum e,Observer observer) {
        observers.get(e).add(observer);
    }

    @Override
    public void removeObserver(EventTypeEnum e,Observer observer) {
        observers.get(e).remove(observer);
    }

    @Override
    public void notifyObservers(EventTypeEnum e) {
        for (Observer o: observers.get(e)) {
            o.update(accounts.get(accounts.size()-1),e);
        }
    }

    public void addAccount(Account account){
        accounts.add(account);
        accountOpened();
    }

    public void accountOpened(){
        notifyObservers(EventTypeEnum.Opening);
    }

    public void accountWithdrawed(){
        notifyObservers(EventTypeEnum.Withdrawing);
    }

    public void accountDeposited(){
        notifyObservers(EventTypeEnum.Depositing);
    }

    public Account getAccount(int id){
        for (Account a:accounts) {
            if(a.getNumber() == id)
                return a;
        }
        return null;
    }



}
