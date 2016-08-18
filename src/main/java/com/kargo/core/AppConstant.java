package com.kargo.core;

/**
 * Created by wasey on 8/16/16.
 */
public class AppConstant {
    public static final String URL = "http://www.google.com";
    public static final String SEARCH_FOR= "kargo";
    public static final String USERNAME = "aamwasey1";
    public static final String AUTOMATE_KEY = "hSRqEJw7xmCdMu4omyRZ";
    public static final String REMOTEURL = "https://" + USERNAME + ":" + AUTOMATE_KEY + "@hub-cloud.browserstack.com/wd/hub";
    public static final StringBuffer verificationErrors = new StringBuffer();
    public static final String dataFile = System.getProperty("user.dir") + "/src/main/resources/KeyWord.txt";
}
