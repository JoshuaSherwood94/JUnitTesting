import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class JunitExample {
    private WebDriver webDriver;
    private static final String BASE_URL = "http://thedemosite.co.uk/";

    @BeforeClass
    public static void init() {
    }

    @Before
    public  void setUp() {
        webDriver = new ChromeDriver();
        webDriver.navigate().to(BASE_URL);
    }

    @Test
    public  void printTest() {
        try {
            TimeUnit.MILLISECONDS.sleep(500);
        } catch (InterruptedException e){
            e.printStackTrace();
        }
        WebElement newUser = webDriver.findElement (By.cssSelector("body > div > center > table > tbody > tr:nth-child(2) > td > div > center > table > tbody > tr > td:nth-child(2) > p > small > a:nth-child(6)"));
        newUser.click();

        WebElement newUsername = webDriver.findElement (By.cssSelector("body > table > tbody > tr > td.auto-style1 > form > div > center > table > tbody > tr > td:nth-child(1) > div > center > table > tbody > tr:nth-child(1) > td:nth-child(2) > p > input"));
        newUsername.sendKeys("Java");

        WebElement newPassword =  webDriver.findElement (By.cssSelector("body > table > tbody > tr > td.auto-style1 > form > div > center > table > tbody > tr > td:nth-child(1) > div > center > table > tbody > tr:nth-child(2) > td:nth-child(2) > p > input[type=\"password\"]"));
        newPassword.sendKeys("Guru");

        WebElement saveButton = webDriver.findElement(By.cssSelector("body > table > tbody > tr > td.auto-style1 > form > div > center > table > tbody > tr > td:nth-child(1) > div > center > table > tbody > tr:nth-child(3) > td:nth-child(2) > p > input[type=\"button\"]"));
        saveButton.click();

        try {
            TimeUnit.MILLISECONDS.sleep(3000);
        } catch (InterruptedException e){
            e.printStackTrace();
        }

        WebElement login = webDriver.findElement (By.cssSelector("body > div > center > table > tbody > tr:nth-child(2) > td > div > center > table > tbody > tr > td:nth-child(2) > p > small > a:nth-child(7)"));
        login.click();

        WebElement username = webDriver.findElement (By.cssSelector("body > table > tbody > tr > td.auto-style1 > form > div > center > table > tbody > tr > td:nth-child(1) > table > tbody > tr:nth-child(1) > td:nth-child(2) > p > input"));
        username.sendKeys("Java");

        WebElement password =  webDriver.findElement (By.cssSelector("body > table > tbody > tr > td.auto-style1 > form > div > center > table > tbody > tr > td:nth-child(1) > table > tbody > tr:nth-child(2) > td:nth-child(2) > p > input[type=\"password\"]"));
        password.sendKeys("Guru");

        WebElement enterButton = webDriver.findElement(By.cssSelector("body > table > tbody > tr > td.auto-style1 > form > div > center > table > tbody > tr > td:nth-child(1) > table > tbody > tr:nth-child(3) > td:nth-child(2) > p > input[type=\"button\"]"));
        enterButton.click();

        WebElement getLogin = webDriver.findElement(By.cssSelector("body > table > tbody > tr > td.auto-style1 > big > blockquote > blockquote > font > center > b"));

        try {
            TimeUnit.MILLISECONDS.sleep(3000);
        } catch (InterruptedException e){
            e.printStackTrace();
        }

        Assert.assertEquals("Login Failed", "**Successful Login**", getLogin.getText());
    }

    @After
    public  void cleanUp() {
        webDriver.quit();
    }

    @AfterClass
    public static void tearDown() {
    }
}
