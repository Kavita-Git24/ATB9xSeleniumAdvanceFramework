package com.SeleniumTesting.tests.Sample;

import io.qameta.allure.Description;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TestSample {
    @Description("Sample TC 1")
    @Test
    public void testSample0(){
        Assert.assertTrue(true);
    }

    @Description("Sample TC 1")
    @Test
    public void testSample1(){
        Assert.assertTrue(true);
    }
}
