package com.kargo.core;

import com.kargo.testmathods.SearchKargo;
import org.openqa.selenium.WebDriver;

/**
 * Created by wasey on 8/16/16.
 */
public class ApplicationController {
    private WebDriver driver;
    private SearchKargo kargo;





    public ApplicationController(WebDriver driver) {
        this.driver = driver;
        kargo = new SearchKargo(driver);




    }



    public SearchKargo getKargo() {
        return kargo;
    }




    public WebDriver getDriver() {
        return driver;
    }
}
