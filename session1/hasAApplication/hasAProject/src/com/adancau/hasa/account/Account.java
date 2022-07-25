package com.adancau.hasa.account;

import com.adancau.hasa.contact.ContactDetails;
import com.adancau.hasa.kyc.KYCVerification;

public class Account {
    private long accountNumber;
    private String username;
    private String password;
    private int balance;
    private KYCVerification kycVerification;
    private ContactDetails contactDetails;
    private int cashback;

    private static final int MINIMUM_ACCOUNT_BALANCE = 5000;
    private static final int ZERO_ACCOUNT_BALANCE = 0;

    public Account(long accountNumber, String username, String password, int balance, KYCVerification kycVerification, ContactDetails contactDetails, int cashback) {
        this.accountNumber = accountNumber;
        this.username = username;
        this.password = password;
        this.balance = balance;
        this.kycVerification = kycVerification;
        this.contactDetails = contactDetails;
        this.cashback = cashback;
    }

    public int deposit(int ammount) {
        if (ammount <= ZERO_ACCOUNT_BALANCE) {
            throw new IllegalArgumentException("Cannot deposit 0 or negative amount.");
        }
        balance += ammount;
        return balance;
    }

    public int withdrawal(int ammount) {
        if (ammount > balance || breaksMinimumAccountBalance(ammount)) {
            throw new RuntimeException("Cannot withdraw. Remaining amount would be smaller than accepted limit.");
        }
        final int cashbackToReturn = getCashback(ammount);
        System.out.println(cashbackToReturn);
        balance = balance - ammount + cashbackToReturn;
        System.out.println(balance);
        return ammount;
    }

    private int getCashback(int ammount) {
        return ammount * cashback / 100;
    }

    private boolean breaksMinimumAccountBalance(int ammount) {
        return (balance - ammount) < MINIMUM_ACCOUNT_BALANCE;
    }

    public long getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(long accountNumber) {
        this.accountNumber = accountNumber;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getBalance() {
        return balance;
    }

    public void setBalance(int balance) {
        this.balance = balance;
    }

    public KYCVerification getKycVerification() {
        return kycVerification;
    }

    public void setKycVerification(KYCVerification kycVerification) {
        this.kycVerification = kycVerification;
    }

    public ContactDetails getContactDetails() {
        return contactDetails;
    }

    public void setContactDetails(ContactDetails contactDetails) {
        this.contactDetails = contactDetails;
    }

    public int getCashback() {
        return cashback;
    }

    public void setCashback(int cashback) {
        this.cashback = cashback;
    }

    @Override
    public String toString() {
        return "Account{" +
                "accountNumber=" + accountNumber +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", balance=" + balance +
                ", kycVerification=" + kycVerification +
                ", contactDetails=" + contactDetails +
                ", cashback=" + cashback +
                '}';
    }
}
