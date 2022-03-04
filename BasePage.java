package com.nopcommerce.demo.Base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class BasePage {

    WebDriver driver;
    Properties prop;
    FileInputStream file;

    public WebDriver initialiseDriver(String browserName) {
        if (browserName.equals("chrome")){
            System.setProperty("webdriver.chrome.driver", "C:\\Users\\dhris\\IdeaProjects\\Selenium\\chromedriver.exe");
            driver = new ChromeDriver();

        } else if (browserName.equals("edge")){
            System.setProperty("webdriver.edge.driver", "C:\\Users\\dhris\\IdeaProjects\\Selenium\\edgedriver.exe");
            driver= new EdgeDriver();

        } else if (browserName.equals("firefox")){
            System.setProperty("webdriver.gecko.driver"," C:\\Users\\dhris\\IdeaProjects\\Selenium\\geckodriver.exe");
            driver = new FirefoxDriver();

        }else {
            System.out.println(browserName + "Please enter correct browser name");
        }
        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();
        return driver;
    }

    public Properties initialiseProperties(){
        prop = new Properties();
        try {
            file = new FileInputStream("C:\\Users\\dhris\\IdeaProjects\\untitled\\pageObjectModelFramework\\" +
                    "POMFramework\\src\\test\\resources\\TestData\\config.properties.properties");
        } catch (FileNotFoundException e){
            System.out.println("file not found please check...");

        } catch (IOException e){
            e.printStackTrace();
        }
        return prop;
    }
}
