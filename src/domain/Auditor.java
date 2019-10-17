package domain;

import javax.swing.*;

public class Auditor implements Observer,Display {

    private Subject subject;
    private int accountTotal;
    private int number;

    public Auditor(Subject subject){
        this.subject = subject;
        accountTotal = 0;
        subject.registerObserver(EventTypeEnum.Opening,this);
    }

    @Override
    public void display() {
        JOptionPane.showMessageDialog(null,
                String.format("New account number: %d\n Total number of accounts:  %d", number, accountTotal),
                "AccountLoger",JOptionPane.INFORMATION_MESSAGE);
    }

    @Override
    public void update(Account account, EventTypeEnum eventTypeEnum) {
        accountTotal++;
        this.number = account.getNumber();
        display();
    }
}
