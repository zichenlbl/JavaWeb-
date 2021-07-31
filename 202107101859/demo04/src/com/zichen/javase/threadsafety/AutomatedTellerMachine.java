package com.zichen.javase.threadsafety;

/**
 * 取款机
 * @author zc
 * @date 2021-07-31 22:46
 */
public class AutomatedTellerMachine extends Thread{
    /**
     * 银行账户
     */
    private BankAccount bankAccount;
    /**
     * 取款金额
     */
    private double money;

    @Override
    public void run() {
        this.bankAccount.withdrawMoney(this.money);
        System.out.println(Thread.currentThread().getName() +
                "线程对账户" + this.bankAccount.getId() +
                "成功取款" + this.money + "元，余额：" +
                this.bankAccount.getBalance() + "元");
    }

    public AutomatedTellerMachine() {
    }

    public AutomatedTellerMachine(BankAccount bankAccount, double money) {
        this.bankAccount = bankAccount;
        this.money = money;
    }

    public AutomatedTellerMachine(BankAccount bankAccount) {
        this.bankAccount = bankAccount;
    }

    public BankAccount getBankAccount() {
        return bankAccount;
    }

    public void setBankAccount(BankAccount bankAccount) {
        this.bankAccount = bankAccount;
    }
}
