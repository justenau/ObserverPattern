package domain;

import javax.swing.*;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Logger implements Observer,Display {

    private Subject subject;
    private Date date;
    private int number;
    private double balance;
    private EventTypeEnum event;

    public Logger(Subject subject){
        this.subject = subject;
        for (EventTypeEnum e:EventTypeEnum.values()) {
            subject.registerObserver(e,this);
        }
    }

    @Override
    public void display() {
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        JOptionPane.showMessageDialog(null,
                String.format("Event %s on date %s with number %d and balance %s", event, dateFormat.format(date), number, balance),
                "Auditor",JOptionPane.INFORMATION_MESSAGE);
    }

    @Override
    public void update(Account account, EventTypeEnum eventTypeEnum) {
        this.date = account.getOpenDate();
        this.number = account.getNumber();
        this.balance = account.getBalance();
        this.event = eventTypeEnum;
        display();
    }
}
