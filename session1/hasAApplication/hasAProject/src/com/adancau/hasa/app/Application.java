package com.adancau.hasa.app;

import com.adancau.hasa.account.Account;
import com.adancau.hasa.contact.ContactDetails;
import com.adancau.hasa.kyc.KYCVerification;

import static java.util.Objects.nonNull;

public class Application {


    static int x;
    int y;

    public static void main(String[] args) {
        Application application = new Application();
        application.y = 1;
        application.x = 1;

        KYCVerification kycVerification = new KYCVerification("pan number", 1L, "ID", "1243");
        ContactDetails contactDetails = new ContactDetails("1", "Bucharest", "Bucharest", "Romania", "Romania", 1L, 2L, 3L);
        Account account = new Account(1L, "name", "password", 5000, kycVerification, contactDetails, 1);

        System.out.println(account);

        application.doDepositOperation(account, 200);
        System.out.println(account);

        application.doWithdrawalOperation(account, 100);
        System.out.println(account);

        application.printBalance(account);
        application.printUserAllDetails(account);
        application.printUserContactDetails(account);
        application.printUserKYCDocumentDetails(account);

        application.changeMobileNumber(account, 0753032761L);
        application.changeEmailId(account, 1L);

         byte b1 = 10;
         byte b2 = 10;
         byte s = (byte) (b1 + b2);
        System.out.println(s);
        short x = 20;
        int a = x;
        long asdas = 1231233l;
        byte xlong = (byte) asdas;
        System.out.println(xlong);

        pls(new Integer(1));
    }

    public static void pls(int x){
        System.out.println("primitiv");
    }

    public static void pls(Integer x){
        System.out.println("wrapper");
    }

    public void submitUserDetails() {

    }

    public void doDepositOperation(Account account, int amountToDeposit) {
        account.deposit(amountToDeposit);
    }

    public void doWithdrawalOperation(Account account, int amountToWithdraw) {
        if (nonNull(account)) {
            int withdrawn = account.withdrawal(amountToWithdraw);
            System.out.println("Withdrawn " + withdrawn + " balance");
        }
    }

    public void printUserAllDetails(Account account) {
        System.out.println(account);
    }

    public void printUserContactDetails(Account account) {
        System.out.println(account.getContactDetails());
    }

    public void printUserKYCDocumentDetails(Account account) {
        if (nonNull(account)) {
            System.out.println(account.getKycVerification());
        }
    }

    public void printBalance(Account account) {
        if (nonNull(account)) {
            System.out.println(account.getBalance());
        }
    }

    public void changeMobileNumber(Account account, Long newMobileNumber) {
        if (nonNull(account)) {
            ContactDetails contactDetails = account.getContactDetails();
            if (nonNull(contactDetails) && nonNull(newMobileNumber)) {
                contactDetails.setMobileNumber(newMobileNumber);
            }
        }
    }

    public void changeEmailId(Account account, Long newEmailId) {
        if (nonNull(account)) {
            ContactDetails contactDetails = account.getContactDetails();
            if (nonNull(contactDetails) && nonNull(newEmailId)) {
                contactDetails.setEmailId(newEmailId);
            }
        }
    }
}
