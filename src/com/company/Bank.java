package com.company;

import java.util.HashMap;
import java.util.Map;

public class Bank {

    private int countAccounts = 0;
    private Map<Integer, Account> accounts = new HashMap<>();

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
        synchronized (accounts.get(senderAccount)) {
            accounts.get(senderAccount).decrease(amount);
        }
        synchronized (accounts.get(paymentReceiver)) {
            accounts.get(paymentReceiver).increase(amount);
        }
    }


    public int getAccountState(Integer accountId) {
        return accounts.get(accountId).getMoney();
    }
}
