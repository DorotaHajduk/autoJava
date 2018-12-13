package selenium.NoweZadanie_13_12_2018.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class wpNotePage {
    public static final By AUTHOR_FIELD = By.id("author");
    public static final By EMAIL_FIELD = By.id("email");
    public static final By SUBMIT_FIELD = By.name("submit");
    //
    private final WebDriver driver;

    public wpNotePage(WebDriver driver) {
        this.driver = driver;
    }

    //Komentarz i stwórz nowy obiekt typy wpNote i przekaz do klasy, zeby zadziałało
    public wpNotePage addcomment(String comment, String author, String email) {
        WebElement CommentArea = driver.findElement(By.id("comment"));
        CommentArea.click();
        CommentArea.sendKeys(comment);
        WebElement Signing = driver.findElement(AUTHOR_FIELD);
        Signing.sendKeys(author);
        WebElement Email = driver.findElement(EMAIL_FIELD);
        Email.sendKeys(email);
        WebElement buttonPost = driver.findElement(SUBMIT_FIELD);
        buttonPost.click();
        return new wpNotePage(driver);
    }

    public boolean commentExist(String comment, String author) {
        //sprawdzam czy jest opublikowany komentarz

        Stream<WebElement> comments = driver.findElements(By.cssSelector(".comment-list > .comment"))

                .stream()
                .filter(c -> c.findElement(By.cssSelector(".comment-author > b")).getText().equals(author))
                .filter(c -> c.findElement(By.cssSelector(".comment-content > p")).getText().equals(comment));
        List<WebElement> collectList = comments.collect(Collectors.toList());

        /* return collectList.size()==1; to to samo co poniższy if:
             if (collectList.size()==1) {
           return true;
       }
       return false;*/
        return collectList.size() == 1;
    }

}
