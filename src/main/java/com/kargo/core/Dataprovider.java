package com.kargo.core;

import org.testng.annotations.DataProvider;

/**
 * Created by wasey on 8/16/16.
 */
public class Dataprovider {

    @DataProvider(name = "KeywordAsArray")
    public static Object[][] dataProviderAsArray() {
        Object[][] data;
        data = new Object[][]{
                {"Mobile ad firm"},
                {"Mobile advertising"},
                {"Mobile marketing"},
                {"Mobile internet"},

        };
        return data;
    }






}