package com.company;

public class TransferMoneyThread extends Thread {

    private Integer senderAccount;
    private Integer paymentReceiver;
    private Bank bank;

    TransferMoneyThread(Bank bank, Integer senderAccount, Integer paymentReceiver) {
        this.bank = bank;
        this.senderAccount = senderAccount;
        this.paymentReceiver = paymentReceiver;
    }

    @Override
    public void run() {
        while (true) {
            bank.transferMoney(senderAccount, paymentReceiver, 10);
            System.out.println("Состояние " + senderAccount + " счёта: " + bank.getAccountState(senderAccount) +
                    "\nСостояние " + paymentReceiver + " счета: " + bank.getAccountState(paymentReceiver) +
                    "\nСумма на всех счетах: " + bank.getAllMoneyInBank());
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
