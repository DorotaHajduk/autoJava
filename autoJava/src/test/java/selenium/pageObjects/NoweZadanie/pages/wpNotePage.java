package selenium.pageObjects.NoweZadanie.pages;

import org.openqa.selenium.WebDriver;

public class wpNotePage {
    //
    private final WebDriver driver;

    public wpNotePage(WebDriver driver) {
        this.driver = driver;
    }
//Komentarz i stwórz nowy obiekt typy wpNote i przekaz do klasy, zeby zadziałało
    public wpNotePage addcomment(String comment, String author, String email) {
        return new wpNotePage(driver);
    }

    public boolean commentExist(String comment, String author) {
        //sprawdzam czy jest opublikowany komentarz
        return false;
    }
}
