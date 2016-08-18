package com.kargo.test;

import com.kargo.core.Dataprovider;
import com.kargo.core.ScriptBase;
import com.kargo.core.Text2TestData;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.HashMap;

import static com.kargo.core.AppConstant.SEARCH_FOR;

/**
 * Created by wasey on 8/16/16.
 */
public class KeywordTest extends ScriptBase {

    @Test
    public void searchforkargo()  {

        google().getDriver();
        google().getKargo().GOToApplication();
        google().getKargo().search(SEARCH_FOR);
        google().getKargo().clickbutton();
        google().getKargo().clickkargowebsite();
        google().getKargo().scrolldown();
        google().getKargo().clickkabout();



    }





    @Test(description = "This is a Keyord Search test",
            dataProvider = "KeywordAsArray",
            dataProviderClass = Dataprovider.class)

    public void kewordSearcharray(String searchkeyword){

        google().getDriver();
        google().getKargo().GOToApplication();
        google().getKargo().search(searchkeyword);
        google().getKargo().clickbutton();
        google().getKargo().delayFor(1000);

    }

    @Test(dataProvider = "keywords", description = "Google_Test")
    public void search(String search) throws Exception {

        google().getDriver();
        google().getKargo().GOToApplication();
        google().getKargo().search("" + search);
        Thread.sleep(4000);



    }
    @DataProvider(name="keywords")
    public Object[][] data() throws Exception {
        HashMap<String,String[]> dataSet= new Text2TestData(System.getProperty("user.dir") + "/src/main/resources/KeyWord.txt").getData();

        String search1Strings[]=dataSet.get("search");

        int size =search1Strings.length;

        // modify 2 upon the no. of rows; Here, I used two rows, 'search1' & 'search2'
        Object[][] creds = new Object[size][1];
        for(int i=0;i<size;i++)
        {
            creds[i][0]=search1Strings[i];

        }
        return creds;
    }

}
