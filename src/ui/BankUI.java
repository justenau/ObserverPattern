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
        String menu = "1. Open account\n2. Deposit account\n3. Withdraw account\n\n0. Program closes";
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
                case 2:
                    depositAccount();
                    break;
                case 3:
                    withdrawAccount();
                    break;
                case 0:
                    return;
                default:
                    JOptionPane.showMessageDialog(null, "Please choose an option from the list!!");
            }
        } while(choice!=0);
    }

    private void withdrawAccount() {
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

        Account account = bank.getAccount(number);
        if(account==null){
            JOptionPane.showMessageDialog(null, "Account not found!");
            return;
        }

        input = JOptionPane.showInputDialog("Enter amount:");
        double withdrawAmount;
        if (input.isEmpty()){
            JOptionPane.showMessageDialog(null, "Withdraw amount field cannot be empty!");
            return;
        }
        try {
            withdrawAmount = Double.parseDouble(input);
        } catch (NumberFormatException e){
            JOptionPane.showMessageDialog(null, "Withdraw amount can contain only digits or '.'!");
            return;
        }
        if(account.getBalance()<withdrawAmount){
            JOptionPane.showMessageDialog(null, "There's not enough money!");
            return;
        }

        account.withdraw(withdrawAmount);
        bank.setUpdatedAccount(account);
        bank.accountWithdrawed();
    }

    private void depositAccount() {
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

        Account account = bank.getAccount(number);
        if(account==null){
            JOptionPane.showMessageDialog(null, "Account not found!");
            return;
        }

        input = JOptionPane.showInputDialog("Enter amount:");
        double depositAmount;
        if (input.isEmpty()){
            JOptionPane.showMessageDialog(null, "Deposit amount field cannot be empty!");
            return;
        }
        try {
            depositAmount = Double.parseDouble(input);
        } catch (NumberFormatException e){
            JOptionPane.showMessageDialog(null, "Deposit amount can contain only digits or '.'!");
            return;
        }

        account.deposit(depositAmount);
        bank.setUpdatedAccount(account);
        bank.accountDeposited();
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
