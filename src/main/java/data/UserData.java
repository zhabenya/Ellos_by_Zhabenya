package data;

import org.testng.annotations.DataProvider;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Random;

/**
 * Created by zhabenya on 03.02.16.
 */
public class UserData {

    @DataProvider
    public static Iterator<Object[]> users(){
        List<Object[]> data = new ArrayList<Object[]>();
        String email = "test_" + new Random().nextInt() + "@gmail.com";
        data.add(new Object[]{email, "12345"});
        return data.iterator();
    }

}
