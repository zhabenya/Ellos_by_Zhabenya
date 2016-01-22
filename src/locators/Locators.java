package locators;

/**
 * Created by zhabenya on 15.01.16.
 */
public class Locators {

    public static String getLoginPageLink(){
        return "//a[@id='showlogin']";
    }

    public static String getLoginEmailInput(){
        return "//fillField[@id='ctl00_ctl00_conMain_conMain_LoginControl_LoginUsername']";
    }

    public static String getLoginPassInput(){
        return ".//fillField[@id='ctl00_ctl00_conMain_conMain_LoginControl_LoginPassword']";
    }

    public static String getLoginSubmitButton(){
        return "//a[@id='ctl00_ctl00_conMain_conMain_LoginControl_LoginButton']";
    }

    public static String getLogoutButton(){
        return ".//a[@id='showlogout']";
    }
}
