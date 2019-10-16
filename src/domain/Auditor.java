package domain;

import javax.swing.*;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Auditor implements Observer,Display {

    private Subject subject;
    private Date date;
    private int number;
    private double balance;

    public Auditor(Subject subject){
        this.subject = subject;
        subject.registerObserver(this);
    }

    @Override
    public void display() {
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        JOptionPane.showMessageDialog(null,
                String.format("New account opened on date %s with number %d and balance %s", dateFormat.format(date), number, balance),
                "Auditor",JOptionPane.INFORMATION_MESSAGE);
    }

    @Override
    public void update(Account account) {
        this.date = account.getOpenDate();
        this.number = account.getNumber();
        this.balance = account.getBalance();
        display();
    }
}
