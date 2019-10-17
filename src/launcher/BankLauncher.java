package launcher;

import domain.Auditor;
import domain.Logger;
import domain.Bank;
import ui.BankUI;

public class BankLauncher {

    public static void main(String[] args){
        Bank bank = new Bank();
        Logger auditor = new Logger(bank);
        Auditor logger = new Auditor(bank);
        BankUI bankUI = new BankUI(bank);
        bankUI.show();
    }
}
