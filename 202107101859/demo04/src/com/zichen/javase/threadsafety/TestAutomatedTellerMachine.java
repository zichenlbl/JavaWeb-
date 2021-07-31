package com.zichen.javase.threadsafety;

/**
 * 测试两个取款机同时取款
 * @author zc
 * @date 2021-07-31 22:57
 */
public class TestAutomatedTellerMachine {
    public static void main(String[] args) {
        BankAccount bankAccount = new BankAccount(1000001, 10000);
        AutomatedTellerMachine atm = new AutomatedTellerMachine(bankAccount, 5000);
        AutomatedTellerMachine atm1 = new AutomatedTellerMachine(bankAccount, 4000);
        atm.start();
        atm1.start();
    }
}
