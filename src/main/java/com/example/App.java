package com.example;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import io.github.bonigarcia.wdm.WebDriverManager;
/**
 * Giselle Schwartz 2023
 *
 */
public class App 
{   
    /**
     * @throws InterruptedException
     * 
     */
    public static void launchBrowser() throws InterruptedException {

        //This manages the version of the chrome driver. If it does not have the right version, it will download it.
        WebDriverManager.chromedriver().clearDriverCache().setup();
        
        ChromeOptions options = new ChromeOptions(); 
        //disable that banner that says "Chrome is being controlled by automated test software"
        options.setExperimentalOption("excludeSwitches", new String[]{"enable-automation"}); 
        options.addArguments("--remote-allow-origins=*");
        
        //needed for running using specific profile
        options.addArguments("--remote-debugging-port=3723");//check command line output to know specific port
        //for creds autofill (use the Cafeteria profile. You will need to create this the first time and log in once and choose "save password. after that it should always just work")
        options.addArguments("--user-data-dir=C:\\Users\\$USERNAME HERE$\\AppData\\Roaming\\Google\\Chrome\\User Data\\Profile 1"); //if not going to the right profile: https://stackoverflow.com/questions/52394408/how-to-use-chrome-profile-in-selenium-webdriver-python-3
        //options.addArguments("--user-data-dir=C:\\Users\\TrackerDIET\\AppData\\Roaming\\Google\\Chrome\\User Data") -does not open the profile
        WebDriver driver = new ChromeDriver(options);
        //go to this page
        driver.get("https://$URL YOU WANT TO GO TO HERE$");
        //maximize the window
        driver.manage().window().maximize();
        //wait for 2 seconds (to allow page to load)
        Thread.sleep(2000);
        try {
            //find the html element named loginfmt
            WebElement emailField = driver.findElement(By.name("loginfmt"));//find by id instead
            //find the html element named idSIButton9
            WebElement nextBtn = driver.findElement(By.id("idSIButton9"));
            //type in the username
            emailField.sendKeys("$USERNAME@DOMAIN.COM$");
            //click next
            nextBtn.click();
            //at this point, if you've logged in at least onece before and saved the password in chrome, it will go straight in
            //if not:
        } catch (Exception e) {
            System.out.checkError();
            System.out.println(e);
        }

        Thread.sleep(4000);
        String url = driver.getCurrentUrl();
        if(url.endsWith("login")){
            WebElement yesBtn = driver.findElement(By.id("idSIButton9"));
            if(yesBtn.isDisplayed()) {
            yesBtn.click();
        }
        }
 
        //endless loop for refreshing the page
        while(true) {
            //hard refresh the page in case of menu changes ^__^
            try {
                TimeUnit.MINUTES.sleep(10);
                driver.navigate().refresh();
            }
            catch(Exception e) {
                //not that helpful error message
                System.out.println(e.toString());
            }
        }

     }
    public static void main( String[] args )
    {
            try {
                launchBrowser();
            }
            catch(Exception e) {
                    //print the error message
                    System.out.println(e.toString());
            }
      
    }
}
