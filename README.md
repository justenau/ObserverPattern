# ObserverPattern

This exercise is intended to practice the mechanism of the observer design pattern. The classes can be written very simply, a user interface in JOptionPane or JavaFx is not necessary, you can test your code in the main method of your Launcher.
Create your own subject/observer classes 
## Version 1.
A bank has a number of accounts. Each account has a number and a balance. The bank has a collection of accounts. New accounts can be opened. An auditor wants to be notified when a new account at the bank is opened. The auditor then presses on the console the text "New account opened on date ... with number .... and balance ...". An AccountLogger also wants to be notified of the opening of the account. He then displays on the console the account number and the total number of accounts of the bank. At a later stage it may be necessary to notify objects of other classes as well!
## Version 2.
In addition to opening accounts, there are 2 other events at the bank of which other classes need to be notified, namely depositing and withdrawing. The auditor only wants to be notified when a new account is opened, the account logger wants to be notified of all events and shows on the console the event name (e.g. open or deposit), the account number and the new balance).
Asked:
1.	Draw a design in a UML class diagram
2.	Write the Java code
