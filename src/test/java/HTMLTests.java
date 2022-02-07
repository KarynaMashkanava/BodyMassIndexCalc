import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;


public class HTMLTests {
    private WebDriver driver;

    @BeforeClass
    public void setProp() {
        System.setProperty("webdriver.chrome.driver", "src/test/java/resources/chromedriver");
    }

    @BeforeMethod
    public void setUp() {
        driver = new ChromeDriver();
        driver.get("http://localhost:63342/BodyMassIndexCalc/resources/index.html?_ijt=o5b07lt9h164bved46d4krv18s&_ij_reload");
    }

    @Test
    public void validateWelcomeMessageTest() {
       Assert.assertTrue(driver.findElement(By.id("header")).isDisplayed());
    }
    @Test
    public void validateSelectAuthorsTest() {
        Assert.assertTrue(driver.findElement(By.id("authors")).isDisplayed());
    }

    @Test
    public void validateButtonTest() {
        Assert.assertTrue(driver.findElement(By.id("button")).isDisplayed());
    }

    @Test
    public void validateMyNameTest() {
        WebElement element = driver.findElement(By.id("my name"));
        Assert.assertTrue(element.getText().contains("Karina"));
    }

    @Test
    public void validateLinkTest() {
        driver.findElement(By.name("citydog")).click();
        String linkResult = driver.getCurrentUrl();
        Assert.assertEquals(linkResult, "https://citydog.by/");
    }

    @Test
    public void validateAltPictureTest() {
        String altPicture = driver.findElement(By.id("picture")).getAttribute("alt");
        Assert.assertEquals(altPicture, "oops, you found it");
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }

}
