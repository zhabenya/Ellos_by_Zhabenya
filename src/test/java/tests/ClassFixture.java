package tests;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;

/**
 * Created by zhabenya on 27.01.16.
 */
@Test
public class ClassFixture extends BrowserFixture {

//    public static Ellos ellos;

    @BeforeClass
    public static void setUpClass() throws Exception {
        ellos.header.clickLogo();
    }

    //TODO:
    @AfterMethod
    public void takeScreenShotOnFailure(ITestResult testResult) throws IOException {
        if (testResult.getStatus() == ITestResult.FAILURE) {
            System.out.println(testResult.getStatus());
            File scrFile = driverWrapper.getScreenshotAs(OutputType.FILE);
            FileUtils.copyFile(scrFile, new File("target/screenshots/" + testResult.getName() + ".jpg"));
        }
    }
}
