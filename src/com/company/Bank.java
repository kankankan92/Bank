package com.company;

import java.util.HashMap;
import java.util.Map;

public class Bank {

    private int countAccounts = 0;
    private Map<Integer, Account> accounts = new HashMap<>();
    final private int LIMIT = 1010;

    public synchronized int getAllMoneyInBank() {
        int sum = 0;
        for (Account account : accounts.values()) {
            sum += account.getMoney();
        }
        return sum;
    }

    public synchronized void createAccount() {
        countAccounts++;
        Account account = new Account(countAccounts);
        accounts.put(countAccounts, account);
    }

    public synchronized void createAccount(int initialAmount) {
        countAccounts++;
        Account account = new Account(countAccounts, initialAmount);
        accounts.put(countAccounts, account);
    }

    //Метод "перевод денег", на вход принимает счёт отправителя, получателя платежа и сумму перевода.
    public void transferMoney(Integer senderAccount, Integer paymentReceiver, int amount) {
        int firstAccount;
        int secondAccount;
        if(senderAccount<paymentReceiver){
            firstAccount = senderAccount;
            secondAccount = paymentReceiver;
        }else{
            firstAccount = paymentReceiver;
            secondAccount = senderAccount;
        }
        synchronized (accounts.get(firstAccount)) {
            synchronized (accounts.get(secondAccount)) {
                if (accounts.get(senderAccount).getMoney() - amount > 0 && accounts.get(paymentReceiver).getMoney() + amount < LIMIT) {
                    accounts.get(senderAccount).decrease(amount);
                    accounts.get(paymentReceiver).increase(amount);
                } else {
                    System.out.println("Неудалось осуществить перевод.");
                }
            }
        }
    }


    public int getAccountState(Integer accountId) {
        return accounts.get(accountId).getMoney();
    }
}
