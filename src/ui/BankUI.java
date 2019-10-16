package ui;

import domain.Account;
import domain.Bank;

import javax.swing.*;

public class BankUI {

    private Bank bank;

    public BankUI(Bank bank){
        this.bank = bank;
    }

    public void show(){
        String menu = "1. Open account\n\n0. Program closes";
        String input;
        int choice;
        do{
            choice=-1;
            input = (JOptionPane.showInputDialog(menu));
            if (input == null)
                return;
            try {
                choice = Integer.parseInt(input);
            } catch (NumberFormatException e){
                JOptionPane.showMessageDialog(null, "Please insert a valid option number!");
                continue;
            }
            switch (choice) {
                case 1:
                    openAccount();
                    break;
                case 0:
                    return;
                default:
                    JOptionPane.showMessageDialog(null, "Please choose an option from the list!!");
            }
        } while(choice!=0);
    }

    public void openAccount(){
        String input= JOptionPane.showInputDialog("Enter the account number:");
        int number;
        if (input.isEmpty()){
            JOptionPane.showMessageDialog(null, "Account number field cannot be empty!");
            return;
        }
        try {
            number = Integer.parseInt(input);
        } catch (NumberFormatException e){
            JOptionPane.showMessageDialog(null, "Account number can contain only digits!");
            return;
        }

        input = JOptionPane.showInputDialog("Enter balance amount:");
        double balance;
        if (input.isEmpty()){
            JOptionPane.showMessageDialog(null, "Balance amount field cannot be empty!");
            return;
        }
        try {
            balance = Double.parseDouble(input);
        } catch (NumberFormatException e){
            JOptionPane.showMessageDialog(null, "Balance amount can contain only digits or '.'!");
            return;
        }

        Account account = new Account(number,balance);
        bank.addAccount(account);
    }
}
