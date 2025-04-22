import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.time.Duration;
import java.util.List;


@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class GuestRegistrationForm {
    WebDriver driver;

    @BeforeAll
    public void setup() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));

    }

    //@Test
    public void visitUrl() {
        driver.get("https://demo.wpeverest.com/user-registration/guest-registration-form/?fbclid=IwY2xjawJyHttleHRuA2FlbQIxMAABHiYvpkpP17-8yG0oGVv2HvDh94_plsGbn5c-jqoQonw42moBUMJGt5ZnhH0E_aem_kwtTvjqm_bLVrRhnfQirzw");
        String titleActual = driver.getTitle();
        String titleExpected = "Guest Registration Form – User Registration";
        Assertions.assertTrue(titleActual.equals(titleExpected));
    }

    @Test
    public void FillupForm() throws InterruptedException {
        driver.get("https://demo.wpeverest.com/user-registration/guest-registration-form/?fbclid=IwY2xjawJyHttleHRuA2FlbQIxMAABHiYvpkpP17-8yG0oGVv2HvDh94_plsGbn5c-jqoQonw42moBUMJGt5ZnhH0E_aem_kwtTvjqm_bLVrRhnfQirzw");
        driver.findElement(By.id("first_name")).sendKeys("Protima Roy");
        driver.findElement(By.id("last_name")).sendKeys("Hasi");
        driver.findElement(By.id("user_email")).sendKeys("joymoni901@gmail.com");
        driver.findElement(By.id("user_pass")).sendKeys("Hasi_Roy%98#");
        // 1. Open date picker
        //WebElement dateInput = driver.findElement(By.cssSelector("input.ur-flatpickr-field"));
        WebElement Birthdate = driver.findElement(By.xpath("//*[@id=\"date_box_1665628538_field\"]/span/input[1]"));
        Birthdate.click();
        // Wait for calendar popup
        Thread.sleep(1000);
        // Pick specific date
        WebElement BirthDay = driver.findElement(By.xpath("/html/body/div[6]/div[2]/div/div[2]/div/span[23]"));
        BirthDay.click();
        WebElement SelectGender = driver.findElement(By.id("radio_1665627729_Female"));
        SelectGender.click();
        driver.findElement(By.id("input_box_1665629217")).sendKeys("Bangladeshi");
        Select country = new Select(driver.findElement(By.id("country_1665629257")));
        Thread.sleep(1000);
        country.selectByVisibleText("Bangladesh");
        Thread.sleep(1000);
        List<WebElement> phnNum = driver.findElements(By.id("phone_1665627880"));
        phnNum.get(1).sendKeys("0171729687");
        List<WebElement> EmergencyphnNum = driver.findElements(By.id("phone_1665627865"));
        EmergencyphnNum.get(1).sendKeys("0171729680");
        WebElement Arrival = driver.findElement(By.xpath("//*[@id=\"date_box_1665629845_field\"]/span/input[1]"));
        Arrival.click();
        // Wait for calendar popup
        Thread.sleep(1000);
        // Pick specific date
        WebElement ArrivalDay = driver.findElement(By.xpath("/html/body/div[7]/div[2]/div/div[2]/div/span[5]"));
        ArrivalDay.click();
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,1000)");
        driver.findElement(By.id("number_box_1665629930")).sendKeys("5");
        driver.findElement(By.id("input_box_1665630010")).sendKeys("Room no 5 & Bed no 7");
        driver.findElement(By.id("textarea_1665630078")).sendKeys("My Occupation is SQA Engineer & place of employment is Dhaka ");
        WebElement Selection = driver.findElement(By.id("radio_1665627931_Yes"));
        Selection.click();
        driver.findElement(By.id("radio_1665627997_Single Room")).click();
        driver.findElement(By.id("radio_1665628131_Vegetarian")).click();
        Select activity = new Select(driver.findElement(By.id("select_1665628361")));
        Thread.sleep(1000);
        activity.selectByVisibleText("Luncheon");
        driver.findElement(By.id("privacy_policy_1665633140")).click();
        List<WebElement> submitBtn = driver.findElements(By.tagName("button"));
        submitBtn.get(4).click();
        WebElement successMsg = driver.findElement(By.xpath("//*[@id=\"ur-submit-message-node\"]/ul"));
        String ActualSuccessMsg = successMsg.getText();
        String ExpectedSuccessdMsg = "User successfully registered.";
        Assertions.assertTrue(ActualSuccessMsg.equals(ExpectedSuccessdMsg));


    }

    //@AfterAll
    public void tearDown(){
        driver.quit();
    }
}
