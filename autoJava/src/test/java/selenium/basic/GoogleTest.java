package selenium.basic;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;
import java.util.UUID;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class GoogleTest {
    private WebDriver driver;

    @BeforeEach
    public void startDriver () {
        System.setProperty("webdriver.chrome.driver", "c:\\selenium\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(7, TimeUnit.SECONDS);
            }

            @Test
            public void ClickNewWebPageAndAddTheComments(){
                driver.get("https://automatyzacja.benedykt.net/");
                WebElement FirstTitleOnPage = driver.findElement(By.cssSelector(".entry-title > a"));
                FirstTitleOnPage.click();
                WebElement CommentArea = driver.findElement(By.id("comment"));
                CommentArea.click();
                CommentArea.sendKeys("HELLO! :)");
                WebElement signing = driver.findElement(By.id("author"));
                UUID uuid = UUID.randomUUID();
                String name = uuid.toString();
                signing.sendKeys(name);
                WebElement email = driver.findElement(By.id("email"));
                email.sendKeys("lalala@gmail.com");
                WebElement buttonPost =driver.findElement(By.name("submit"));
                buttonPost.click();
                Stream<WebElement> ListOfAuthors = driver.findElements(By.className("comment-meta")).stream()
                        .filter(r-> r.findElement(By.tagName("b")).getText().equals(name) );
                List<WebElement> resultList = ListOfAuthors.collect(Collectors.toList());
                Assertions.assertEquals(1, resultList.size());

                            }

    @AfterEach
   public void closeDriver() {
       driver.quit();

    }

}
