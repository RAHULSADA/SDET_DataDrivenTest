package com.rahul;

import com.rahul.utilities.Utilities;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.IOException;

public class Main {

    @Test(dataProvider = "StudentData")
    public void printDataTest(String regNo, String name, String course, String city) {
        System.out.println("Reg No.: " + regNo + " Name: " + name + " Course: " + course + " City: " + city);
    }

    @DataProvider(name = "StudentData")
    public Object[][] getData() throws IOException {
        return Utilities.readExcel();
    }
}
