package utils;

/**
 * Created by zhabenya on 20.01.16.
 */
public class Generator {

    public static String generateEmail(){
        return "mail" + Math.abs(Math.random()*10000) + "@gmail.com";
    }

}
