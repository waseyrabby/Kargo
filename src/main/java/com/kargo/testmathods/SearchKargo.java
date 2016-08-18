package com.kargo.testmathods;

import com.kargo.Drivers.ResourceFactory;
import com.kargo.core.PageBase;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;

/**
 * Created by wasey on 8/16/16.
 */
public class SearchKargo extends PageBase {
    private WebDriver driver = null;
    @FindBy(how = How.ID, using = "lst-ib")
    private WebElement search;
    @FindBy(how = How.ID, using = "sblsbb")
    private WebElement clickbutton;
    @FindBy(how = How.LINK_TEXT, using = "Website")
    private WebElement clickkargowebsite;
    @FindBy(how = How.CSS, using = "img[alt=\"scroll\"]")
    private WebElement scrolldown;
    @FindBy(how = How.XPATH, using = ".//*[@id='menu-item-5826']/a")
    private WebElement clickkabout;



    public SearchKargo(WebDriver driver) {
        super(driver);
        this.driver = driver;
        int timeoutValue = 30;
        PageFactory.initElements(new AjaxElementLocatorFactory(driver, timeoutValue), this);
    }

    public void GOToApplication(){
        driver.navigate().to(ResourceFactory.getInstance().getProperty("APP_URL").toString());

    }

    public void search(String searchfor)
    {
        search.clear();
        highlight(search);
        search.sendKeys(searchfor);
    }

    public void clickbutton()
    {
        clickbutton.click();
    }
    public void clickkargowebsite()
    {
        clickkargowebsite.click();

    }
    public void scrolldown(){
        scrolldown.click();
    }
    public void clickkabout(){
        clickkabout.click();
    }






}
