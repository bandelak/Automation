package pages;

import support.Events;

public class CommonPage {

    public final static String logout="//*[contains(@href,'logout.htm')]";
    public static void clickLogout(){
        Events.click( logout,"logout link");
    }

    public final static String openAccount="//*[contains(@href,'openaccount.htm')]";
    public static String isOpenAccountPresent(){
        String str=Events.isElementPresent( openAccount,"open account link");
        return "open account "+str;
    }

    public final static String accountsOverview="//*[contains(@href,'aaasaoverview.htm')]";
    public static String isAccountsOverviewPresent() {
        String str=Events.isElementPresent( accountsOverview,"open account link");
        return "accounts overview "+str;
    }

    public final static String transferFunds="//*[contains(@href,'transfer.htm')]";
    public static String isTransferFundsPresent(){
        String str=Events.isElementPresent( transferFunds,"open account link");
        return "transfer funds "+str;
    }

    public final static String findTransactions="//*[contains(@href,'findtrans.htm')]";
    public static String isFindTransactionsPresent() {
        String str=Events.isElementPresent( findTransactions,"open account link");
        return "find transactions "+str;
    }
}
