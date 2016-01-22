package exceptions;

import java.io.IOException;

/**
 * Created by zhabenya on 18.01.16.
 */
public class ElementNotFoundException extends IOException {

    public ElementNotFoundException() {
        super("Element not found");
    }

}
