package com.company;

public class Main {

    public static void main(String[] args) {
        Bank bank = new Bank();
        bank.createAccount(1000);
        bank.createAccount();
        bank.createAccount(100);
        TransferMoneyThread transferMoneyThread = new TransferMoneyThread(bank, 1, 2);
        transferMoneyThread.start();
        TransferMoneyThread transferMoneyThread1 = new TransferMoneyThread(bank, 2, 3);
        transferMoneyThread1.start();
        TransferMoneyThread transferMoneyThread2 = new TransferMoneyThread(bank, 3, 1);
        transferMoneyThread2.start();
//        System.out.println("Состояние первого счёта: " + bank.getAccountState(1) +
//                "\nСостояние второго счета: " + bank.getAccountState(2) +
//                "\nСумма на всех счетах: " + bank.getAllMoneyInBank());
//        bank.transferMoney(1, 2, 100);
//        System.out.println("Состояние первого счёта: " + bank.getAccountState(1) +
//                "\nСостояние второго счета: " + bank.getAccountState(2) +
//                "\nСумма на всех счетах: " + bank.getAllMoneyInBank());
    }
}
