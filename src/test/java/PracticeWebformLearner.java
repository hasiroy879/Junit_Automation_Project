import org.junit.jupiter.api.*;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import java.time.Duration;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class PracticeWebformLearner {
    WebDriver driver;

    @BeforeAll
    public void setup(){
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));

    }
    //@Test
    public void visitUrl(){
        driver.get("https://www.digitalunite.com/practice-webform-learners?fbclid=IwY2xjawJyCdZleHRuA2FlbQIxMAABHq4-MPfXy9J2ybec1fQEILJm1zR-3Srmwjdk0RWogrk6LRKv-wzwQfZaEOrS_aem_41PfgZ4cJiZmMCG1PwAfzw");
        String titleActual = driver.getTitle();
        String titleExpected = "Practice webform for learners | Digital Unite";
        Assertions.assertTrue(titleActual.equals(titleExpected));
    }
    @Test
    public void fillupForm() throws InterruptedException {
        driver.get("https://www.digitalunite.com/practice-webform-learners?fbclid=IwY2xjawJyCdZleHRuA2FlbQIxMAABHq4-MPfXy9J2ybec1fQEILJm1zR-3Srmwjdk0RWogrk6LRKv-wzwQfZaEOrS_aem_41PfgZ4cJiZmMCG1PwAfzw");
        JavascriptExecutor js = (JavascriptExecutor) driver;
        driver.findElement(By.id("edit-name")).sendKeys("Hasi Roy");
        driver.findElement(By.id("edit-number")).sendKeys("01717296879");
        driver.findElement(By.id("edit-email")).sendKeys("hasiroy.cse123@gmail.com");
        WebElement date = driver.findElement(By.id("edit-date"));
        js.executeScript("arguments[0].removeAttribute('disabled');", date);
        //js.executeScript("arguments[0].removeAttribute('readonly');", date);
        date.sendKeys("04-21-2025");

        driver.findElement(By.id("edit-tell-us-a-bit-about-yourself-")).sendKeys("I'm a simple girl. I always try my best to" +
                " help others because it is my responsibility");
        driver.findElement(By.id("edit-uploadocument-upload")).sendKeys("C:\\Users\\User\\Downloads\\HASI_ROY.pdf");
        js.executeScript("window.scrollBy(0,500)");
        WebElement checkbox = driver.findElement(By.id("edit-age"));
        Thread.sleep(7000);
        checkbox.click();
        WebElement submitBtn = driver.findElement(By.id("edit-submit"));
        submitBtn.click();
        Thread.sleep(2000);
        WebElement successMsg = driver.findElement(By.xpath("//*[@id=\"block-pagetitle-2\"]/h1"));
        String ActualSuccessMsg = successMsg.getText();
        String ExpectedSuccessdMsg = "Thank you for your submission!";
        Assertions.assertTrue(ActualSuccessMsg.equals(ExpectedSuccessdMsg));

    }

    //@AfterAll
    public void tearDown(){
        driver.quit();
    }
}
