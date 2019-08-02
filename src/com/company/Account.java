package com.company;

public class Account {
    private int money;
    private int accountId;

    Account(int accountId, int initialAmount) {
        this.accountId = accountId;
        money = initialAmount;
    }

    Account(int accountId) {
        this.accountId = accountId;
        money = 0;
    }

    public int getMoney() {
        return money;
    }

    public void decrease(int amount) {
        money -= amount;
    }

    public void increase(int amount) {
        money += amount;
    }
}
