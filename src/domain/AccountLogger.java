package domain;

import javax.swing.*;

public class AccountLogger implements Observer,Display {

    private Subject subject;
    private int accountTotal;
    private int number;

    public AccountLogger(Subject subject){
        this.subject = subject;
        accountTotal = 0;
        subject.registerObserver(this);
    }

    @Override
    public void display() {
        JOptionPane.showMessageDialog(null,
                String.format("New account number: %d\n Total number of accounts:  %d", number, accountTotal),
                "AccountLoger",JOptionPane.INFORMATION_MESSAGE);
    }

    @Override
    public void update(Account account) {
        accountTotal++;
        this.number = account.getNumber();
        display();
    }
}
