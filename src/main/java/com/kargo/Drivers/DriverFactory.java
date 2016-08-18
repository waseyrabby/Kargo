package com.kargo.Drivers;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.phantomjs.PhantomJSDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.safari.SafariDriver;

import java.net.MalformedURLException;
import java.net.URL;

import static com.kargo.core.AppConstant.REMOTEURL;

/**
 * Created by wasey on 8/16/16.
 */
public class DriverFactory {


    private DriverFactory() {
        //Do-nothing..Do not allow to initialize this class from outside
    }


    private static DriverFactory instance = new DriverFactory();

    public static DriverFactory getInstance() {
        return instance;
    }

    ThreadLocal<WebDriver> driver = new ThreadLocal<WebDriver>() // thread local driver object for webdriver
    {
        @Override
        protected WebDriver initialValue() {

            String driverName = ResourceFactory.getInstance().getProperty("DRIVER").toString();
            DesiredCapabilities caps = new DesiredCapabilities();

            if (driverName.toUpperCase().contentEquals("SAFARI")){
                return new SafariDriver();
            }
            else if (driverName.toUpperCase().contentEquals("CHROME")) {
                String chromeBinayPath;
                chromeBinayPath = System.getProperty("user.dir") + "/Drivers/chromedriver 2";
                System.setProperty("webdriver.chrome.driver", chromeBinayPath);
                return new ChromeDriver();
            } else if (driverName.toUpperCase().contentEquals("IE")) {
                String ieBinayPath;
                ieBinayPath = System.getProperty("user.dir") + "/Drivers/chromedriver";
                System.setProperty("webdriver.ie.driver", ieBinayPath);
                return new InternetExplorerDriver();
            } else if (driverName.toUpperCase().contentEquals("HTML")) {

                return new HtmlUnitDriver();
            } else if (driverName.toUpperCase().contentEquals("FIREFOX")) {
                return new FirefoxDriver();
            } else if (driverName.toUpperCase().contentEquals("PHANTOMJS")) {
                String phantomBinayPath;
                phantomBinayPath = System.getProperty("user.dir") + "/Drivers/phantomjs";
                System.setProperty("phantomjs.binary.path", phantomBinayPath);
                return new PhantomJSDriver();
            } else if (driverName.toUpperCase().contentEquals("RD-IE")) {


                caps.setCapability("browser", "IE");
                caps.setCapability("browser_version", "11.0");
                caps.setCapability("os", "Windows");
                caps.setCapability("os_version", "10");
                caps.setCapability("resolution", "1280x1024");

                caps.setCapability("browserstack.debug", "true");

                WebDriver driver = null;
                try {
                    driver = new RemoteWebDriver(new URL(REMOTEURL), caps);
                } catch (MalformedURLException e) {
                    e.printStackTrace();
                }
                return driver;
            }else if (driverName.toUpperCase().contentEquals("RD-IPHONE")) {


                caps.setCapability("browserName", "iPhone");
                caps.setPlatform(org.openqa.selenium.Platform.MAC);
                caps.setCapability("device", "iPhone 5");
                caps.setCapability("browserstack.debug", "true");

                WebDriver driver = null;
                try {
                    driver = new RemoteWebDriver(new URL(REMOTEURL), caps);
                } catch (MalformedURLException e) {
                    e.printStackTrace();
                }
                return driver;
            }else if (driverName.toUpperCase().contentEquals("RD-SAFARI")) {

                caps.setCapability("browser", "Safari");
                caps.setCapability("browser_version", "5.1");
                caps.setCapability("os", "OS X");
                caps.setCapability("os_version", "Snow Leopard");
                caps.setCapability("resolution", "1280x1024");
                caps.setCapability("browserstack.debug", "true");

                WebDriver driver = null;
                try {
                    driver = new RemoteWebDriver(new URL(REMOTEURL), caps);
                } catch (MalformedURLException e) {
                    e.printStackTrace();
                }
                return driver;
            }




            else

            {
                return new FirefoxDriver();
            }
        }
    };
    public WebDriver getDriver() // call this method to get the driver object and launch the browser
    {
        return driver.get();
    }


    public void removeDriver() // Quits the driver and closes the browser
    {
        driver.get().quit();
        driver.remove();
    }}



