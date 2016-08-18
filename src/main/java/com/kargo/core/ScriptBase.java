package com.kargo.core;

import com.kargo.Drivers.DriverFactory;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.util.concurrent.TimeUnit;

import static com.kargo.core.AppConstant.verificationErrors;
import static org.testng.Assert.fail;

/**
 * Created by wasey on 8/16/16.
 */
public class ScriptBase {



    protected WebDriver driver;
    private ThreadLocal<ApplicationController> threadedApplication = null;

    @BeforeMethod
    public void startUp()throws Exception{
        driver = DriverFactory.getInstance().getDriver();
        driver.manage().deleteAllCookies();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        threadedApplication = new ThreadLocal<ApplicationController>(){
            @Override
            protected ApplicationController initialValue()
            {
                return new ApplicationController(DriverFactory.getInstance().getDriver());
            }
        };

    }

    public ApplicationController google(){
        return threadedApplication.get();
    }

    @AfterMethod
    public void tearDown()throws Exception{
        DriverFactory.getInstance().removeDriver();
        String verificationErrorString = verificationErrors.toString();
        if (!"".equals(verificationErrorString)) {
            fail(verificationErrorString);
        }
    }
}
