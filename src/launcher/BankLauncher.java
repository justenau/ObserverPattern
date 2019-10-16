package launcher;

import domain.AccountLogger;
import domain.Auditor;
import domain.Bank;
import ui.BankUI;

public class BankLauncher {

    public static void main(String[] args){
        Bank bank = new Bank();
        Auditor auditor = new Auditor(bank);
        AccountLogger logger = new AccountLogger(bank);
        BankUI bankUI = new BankUI(bank);
        bankUI.show();
    }
}
