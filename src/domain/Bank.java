package domain;

import java.util.ArrayList;
import java.util.HashMap;

public class Bank implements Subject {

    private HashMap<EventTypeEnum,ArrayList<Observer>> observers;
    private HashMap<Integer,Account> accounts;
    private Account updatedAccount;


    public Bank(){
        observers = new HashMap<>();
        for (EventTypeEnum e: EventTypeEnum.values()) {
            observers.put(e,new ArrayList<>());
        }
        accounts = new HashMap<>();
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
            o.update(updatedAccount,e);
        }
    }

    public void addAccount(Account account){
        accounts.put(account.getNumber(),account);
        updatedAccount = account;
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
        return accounts.get(id);
    }

    public void setUpdatedAccount(Account updatedAccount) {
        this.updatedAccount = updatedAccount;
    }
}
