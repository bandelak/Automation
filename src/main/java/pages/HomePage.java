package pages;

import support.Base;
import support.Events;

public class HomePage {

    public final static String logout="//*[contains(@href,'logout.htm')]";
    public static void clickLogout(){
        Events.click( logout,"logout link");
    }

}
