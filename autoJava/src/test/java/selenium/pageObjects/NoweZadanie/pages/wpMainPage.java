package selenium.pageObjects.NoweZadanie.pages;

import org.openqa.selenium.WebDriver;

public class wpMainPage {
    private final WebDriver driver;

    public wpMainPage(WebDriver driver) {
        //tworzymy sobie drivera (create field). Na górze robi się wpis
        this.driver = driver;
         // tu otwiera się wordpress page
    }
//samo sie wygeneruje poniżej jak na klasie testowej tworzymy nową metodę
    public wpNotePage openLatestNote() {
        //tu podpoeiwdziął automatycznie return null ale my chcemy, żeby zwrócił nam nowy obiekt typu wpNotePage w driverze czyli w przeglądarce
        return new wpNotePage(driver);
    }
}
