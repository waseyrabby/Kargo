package com.kargo.core;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileReader;
import java.util.HashMap;

/**
 * Created by wasey on 8/17/16.
 */
public class Text2TestData {



        private String fileLocation;

        public Text2TestData(String dataFile) {
            this.fileLocation = AppConstant.dataFile;
        }

        public HashMap<String,String[]> getData(){
            FileInputStream fs;
            HashMap<String,String[]> keyValuePair=new HashMap<String,String[]>();
            try (BufferedReader br = new BufferedReader(new FileReader(fileLocation))){
                String stringLine;

                while ((stringLine = br.readLine()) != null)   {

                    String[] keyValue=stringLine.split("=");
                    keyValuePair.put(keyValue[0],keyValue[1].split(","));
                }

            } catch (Exception e) {
                e.printStackTrace();
            }

            return keyValuePair;
        }

    }
