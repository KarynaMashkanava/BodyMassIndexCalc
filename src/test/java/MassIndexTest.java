import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.*;

public class MassIndexTest {

    private WebDriver driver;

    @BeforeClass
    public void setProp() {
        System.setProperty("webdriver.chrome.driver", "src/test/java/resources/chromedriver");
    }

    @BeforeMethod
    public void setUp() {
        driver = new ChromeDriver();
        driver.get("https://healthunify.com/bmicalculator/");
    }

    @Test
    public void starvationTest() {
        driver.findElement(By.xpath("//input[@name = 'wg']")).sendKeys("11");
        driver.findElement(By.xpath("//input[@name = 'ht']")).sendKeys("180");
        driver.findElement(By.xpath("//input[@name = 'cc']")).click();
        String textResult = driver.findElement(By.xpath("//input[@name = 'desc']")).getAttribute("value");
        Assert.assertEquals(textResult, "Your category is Starvation");
    }

    @Test
    public void underweightTest() {
        driver.findElement(By.xpath("//input[@name = 'wg']")).sendKeys("50");
        driver.findElement(By.xpath("//input[@name = 'ht']")).sendKeys("180");
        driver.findElement(By.xpath("//input[@name = 'cc']")).click();
        String textResult = driver.findElement(By.xpath("//input[@name = 'desc']")).getAttribute("value");
        Assert.assertEquals(textResult, "Your category is Underweight");
    }

    @Test
    public void normalTest() {
        driver.findElement(By.xpath("//input[@name = 'wg']")).sendKeys("70");
        driver.findElement(By.xpath("//input[@name = 'ht']")).sendKeys("180");
        driver.findElement(By.xpath("//input[@name = 'cc']")).click();
        String textResult = driver.findElement(By.xpath("//input[@name = 'desc']")).getAttribute("value");
        Assert.assertEquals(textResult, "Your category is Normal");
    }

    @Test
    public void overweightTest() {
        driver.findElement(By.xpath("//input[@name = 'wg']")).sendKeys("90");
        driver.findElement(By.xpath("//input[@name = 'ht']")).sendKeys("180");
        driver.findElement(By.xpath("//input[@name = 'cc']")).click();
        String textResult = driver.findElement(By.xpath("//input[@name = 'desc']")).getAttribute("value");
        Assert.assertEquals(textResult, "Your category is Overweight");
    }

    @Test
    public void obeseTest() {
        driver.findElement(By.xpath("//input[@name = 'wg']")).sendKeys("110");
        driver.findElement(By.xpath("//input[@name = 'ht']")).sendKeys("180");
        driver.findElement(By.xpath("//input[@name = 'cc']")).click();
        String textResult = driver.findElement(By.xpath("//input[@name = 'desc']")).getAttribute("value");
        Assert.assertEquals(textResult, "Your category is Obese");
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }
}
