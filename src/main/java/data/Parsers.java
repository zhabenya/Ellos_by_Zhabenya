package data;

import static java.lang.Integer.parseInt;

/**
 * Created by zhabenya on 18.02.16.
 */
public class Parsers {

    public static Integer parsePrice(String priceText) {
        priceText = priceText.replaceAll("\\D+","");;
        return parseInt(priceText);
    }

    public static String parseProductName(String name){
        return name.substring(0, name.indexOf(" "));
    }
}
