package com.zichen.javase.threadsafety;

/**
 * 银行账户
 * @author zc
 * @date 2021-07-31 22:34
 */
public class BankAccount {
    /**
     * 银行卡号
     */
    private Integer id;
    /**
     * 余额
     */
    private double balance;

    /**
     * 取款操作
     * @param money 取款的金额
     */
    protected void withdrawMoney(double money) {
        // 加锁
        synchronized (this) {
            double before = this.getBalance();
            double after = before - money;
            try {
                // 模拟取款时的网络延迟
                Thread.sleep(300);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            this.setBalance(after);
        }
    }

    public BankAccount() {
    }

    public BankAccount(Integer id, double balance) {
        this.id = id;
        this.balance = balance;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }
}
