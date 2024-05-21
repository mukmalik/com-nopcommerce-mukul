package project1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.time.Duration;

public class MultiBrowser {

    // 1. Setup chrome browser

    static String browser = "Chrome";
    static String url = "https://demo.nopcommerce.com/";
    static WebDriver driver;


    public static void main(String[] args) {


        if (browser.equalsIgnoreCase("Chrome")){
            driver = new ChromeDriver();
        } else if (browser.equalsIgnoreCase("Firefox")){
            driver = new FirefoxDriver();
        } else if (browser.equalsIgnoreCase("Edge")){
            driver = new EdgeDriver();
        } else {
            System.out.println("Wrong Browser name");
        }


        // 2. Open URL
        driver.get(url);

        // 3. Print the title of the page
        String str = driver.getTitle();
        System.out.println("Title of the page is :\t"+str);

        // 4. Print current URL
        System.out.println("Current URl of the page is : \t"+driver.getCurrentUrl());

        // 5. Print page source
        System.out.println("Page Source is :\t"+driver.getPageSource());

        // 6. Navigate to Login page
        String loginUrl = "https://demo.nopcommerce.com/login?returnUrl=%2F";
        driver.navigate().to(loginUrl);

        // 7. Print current URL
        System.out.println("Print current url :\t"+driver.getCurrentUrl());

        // 8. Navigate back to the home page
        driver.navigate().back();

        // 9.Navigate to Login page
        driver.navigate().to(loginUrl);

        // 10. Print current URL
        System.out.println("Print current url :\t"+driver.getCurrentUrl());

        // 11. Refresh the page
        driver.navigate().refresh();

        // 12. Enter email to email field
        WebElement emailEl = driver.findElement(By.id("Email"));
        emailEl.sendKeys("prime@prime.com");


        // 13. Enter email to email field
        WebElement passEl = driver.findElement(By.id("Password"));
        passEl.sendKeys("Prime123");

        // 14. Click on Login button
        WebElement but =  driver.findElement(By.cssSelector("button[class='button-1 login-button']"));
        but.click();

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));

        // 15. Close the browser
        driver.close();

    }
}
