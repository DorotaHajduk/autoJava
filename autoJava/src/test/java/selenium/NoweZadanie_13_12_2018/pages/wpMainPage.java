package selenium.NoweZadanie_13_12_2018.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class wpMainPage {
    public static final String PAGE_URL = "https://automatyzacja.benedykt.net/";
    public static final By LATEST_COMMENT_SELECTOR = By.cssSelector(".entry-title > a");
    private final WebDriver driver;

    public wpMainPage(WebDriver driver) {
        //tworzymy sobie drivera (create field). Na górze robi się wpis
        this.driver = driver;
         // tu otwiera się wordpress page
        this.driver.get(PAGE_URL);
    }
//samo sie wygeneruje poniżej jak na klasie testowej tworzymy nową metodę
    public wpNotePage openLatestNote() {
        WebElement LatestComment = driver.findElement(LATEST_COMMENT_SELECTOR);
        LatestComment.click();

        //tu podpoeiwdziął automatycznie return null ale my chcemy, żeby zwrócił nam nowy obiekt typu wpNotePage w driverze czyli w przeglądarce
        return new wpNotePage(driver);

    }

}
