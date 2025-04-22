import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import java.io.FileWriter;
import java.io.IOException;
import java.time.Duration;
import java.util.List;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class ScrapTableData {
    WebDriver driver;

    @BeforeAll
    public void setup(){
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));

    }
    //@Test
    public void visitUrl(){
        driver.get("https://dsebd.org/latest_share_price_scroll_by_value.php?fbclid=IwY2xjawJ0G4NleHRuA2FlbQIxMAABHqFw4-GajGwwiHxbS1xcmjeziigrleVKR-sOEVh-V3xN_9edT9OtX1XHHyar_aem_6WyzfFZxiQfkQTelVSeL0w");
        String titleActual = driver.getTitle();
        String titleExpected = "Latest Share Price by Value | Dhaka Stock Exchange";
        Assertions.assertTrue(titleActual.equals(titleExpected));
    }
    @Test
    public void scrapData() throws IOException {
        driver.get("https://dsebd.org/latest_share_price_scroll_by_value.php?fbclid=IwY2xjawJ0G4NleHRuA2FlbQIxMAABHqFw4-GajGwwiHxbS1xcmjeziigrleVKR-sOEVh-V3xN_9edT9OtX1XHHyar_aem_6WyzfFZxiQfkQTelVSeL0w");
        WebElement table = driver.findElement(By.className("floatThead-wrapper"));
        List<WebElement> allRows = table.findElements(By.tagName("tr"));
        FileWriter file = new FileWriter("D:\\SQA\\Assignment_jUnit\\JunitAssignment\\dataCollect.txt");
        // File to write
        int i=0;
        for(WebElement row : allRows){
            List<WebElement> cells = row.findElements(By.tagName("td"));
            for(WebElement cell : cells){
                i++;
               String data = cell.getText();
                System.out.print(i + " " + data + "\t"); // Print to console
                file.write(data + "\t");     // Write to file
            }
            System.out.println();
            file.write("\n"); // New line for each row in file
        }
        file.close();
    }
    @AfterAll
    public void tearDown(){
        driver.quit();
    }
}
