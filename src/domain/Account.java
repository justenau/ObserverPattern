package domain;

import java.util.Date;

public class Account {

    private int number;
    private double balance;
    private Date openDate;

    public Account(int number, double balance){
        this.number = number;
        this.balance = balance;
        this.openDate = new Date(System.currentTimeMillis());
    }

    public void setBalance(double balance){
        this.balance = balance;
    }

    public double getBalance() {
        return balance;
    }

    public int getNumber() {
        return number;
    }

    public Date getOpenDate() {
        return openDate;
    }

    public void withdraw(double amount){
        balance -=amount;
    }

    public void deposit(double amount){
        balance+=amount;
    }
}
