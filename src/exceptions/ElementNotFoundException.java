package exceptions;

import java.io.IOException;

/**
 * Created by zhabenya on 18.01.16.
 */
public class ElementNotFoundException extends IOException {

    public ElementNotFoundException(String locator) {
        super("Element with locator " + locator + " not found");
    }

}
