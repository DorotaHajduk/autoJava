package selenium.NoweZadanie_13_12_2018;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import selenium.NoweZadanie_13_12_2018.pages.wpMainPage;
import selenium.NoweZadanie_13_12_2018.pages.wpNotePage;

import java.util.UUID;

public class WordpressTest extends BaseTest {



    @Test
    public void canAddCommentToFirstNote() {
        //otwarcie nowej strony https://automatyzacja.benedykt.net/ (do wywalenia???)
        String pageUrl = "https://automatyzacja.benedykt.net/";




        //chce miec unikatowe komentarze (wygenerowane poprzez Create new method)
        String comment = generateRandomText();
        //chce mieć unikatowych autorów (wygenerowane poprzez Create new method)
        String author = generateRandomText();
        //chce mieć unikatowe adresy email do stałego tekstu (wygenerowane poprzez Create new method)
        String email =  generateRandomEmail();

        //otwarcie pierwszej notki
        //dodac komentarz do noty
        wpMainPage mainPage = new wpMainPage(driver);
        //wołamy metodę "otworzyc osttanią notke na stronie" i otwiera się nowa strona wpNotePage
        wpNotePage LatestNote = mainPage.openLatestNote();
        //opublokowanie notki - zwraca nam nową stronę z komentarzem (są na czerwono comment i reszta - robię "create local variable

        wpNotePage LatestNoteWithComment = LatestNote.addcomment(comment, author, email);
        //jak się to już opublikuje to chce zrobic asercję, czyli jak zobacze komentarz, to będzie mial komentarz i autora
        Assertions.assertTrue(LatestNoteWithComment.commentExist(comment, "author"));


    }
    //to się wygenerowało same poprzez storzenie generateRandomEmail
    private String generateRandomEmail() {
        return generateRandomText() + "@testdomin.com";
    }
    //to się wygenerowało same poprzez storzenie generateRandomText
    private String generateRandomText() {
        //zwróć obiekt wygenerowany i zrób z niego stringa (tekst)
        return UUID.randomUUID().toString();
    }
}










//#eu-cookie-law input  (znajdź mi element co ma w środku "eu-cookie-law")
//
//#123 (szukaj mi elementu123)
//.abc.def (klasa)
//elementx#123.abc.dot (szukam klase po id 123 )
//
//cssselector - nie zakłada, że są to tylko klasy o tej treści
//name - zakłada, że jest taka nazwa klasy
//
//
// // inny zapis powyższego testu (drugi test selenium)
//
//       // @Test
//       // public void verifyAuthorOfBlogNoteAboutTransformationsStepByStep() {
//         //   driver.get("http://markowicz.pro/");
//
//          //  List<WebElement> listOfNotes = driver.findElements(By.className("entry-title"));
//
//          //  Stream<WebElement> streamOfNotes = listOfNotes.stream();
//
//          //  Stream<WebElement> filteredStream = streamOfNotes
//
//              //      .filter(n -> n.findElement(By.tagName("a")).getText().equals("O transformacjach"));
//
//           // List<WebElement> filteredNotes = filteredStream.collect(Collectors.toList());
//
//           // Assertions.assertEquals(1, filteredNotes.size(), "Only one matching note is found on main page");
//
//       // }
//
//
//
////Rafała (pierwszy test selenium)
//
//package selenium.basic;
//
//        import org.junit.jupiter.api.AfterEach;
//        import org.junit.jupiter.api.Assertions;
//        import org.junit.jupiter.api.BeforeEach;
//        import org.junit.jupiter.api.Test;
//        import org.openqa.selenium.By;
//        import org.openqa.selenium.WebDriver;
//        import org.openqa.selenium.WebElement;
//        import org.openqa.selenium.chrome.ChromeDriver;
//
//        import java.util.List;
//        import java.util.stream.Collectors;
//        import java.util.stream.Stream;
//
//public class SeleniumTests {
//
//    // This field (variable named 'driver') must be declared on class level (not inside any method) so that it can be shared across all methods
//    private WebDriver driver;
//
//    // This will execute before each test case (before each method annotated with @Test is executed)
//    @BeforeEach
//    public void startDriver() {
//        // Start Chrome browser
//        driver = new ChromeDriver();
//    }
//
//    @Test
//    public void canFindCodeSprintersOnGoogle() {
//
//        // Open Google page in browser
//        driver.get("https://www.google.com");
//
//        // Find search box by its HTML attribute name that is equal 'q'
//        WebElement searchBox = driver.findElement(By.name("q"));
//
//        // Type in search text into search box
//        searchBox.sendKeys("code sprinters");
//
//        // Submit query to see google results page
//        searchBox.submit();
//
//        // Find all 10 results on a page and create stream ('collection') to be able to filter results easily
//        // We search using CSS selector for all HTML div elements that have class equal 'rc'
//        Stream<WebElement> searchResults = driver.findElements(By.cssSelector("div.rc")).stream();
//
//        // Filter results so that in new stream only results matching our filtering criteria remain
//        // The condition searches within each of 10 elements for HTML div that has class 'r' and HTML anchor (a) inside
//        // Then we pull value of HTML attribute href for that anchor and compare it with expected URL "http://agileszkolenia.pl/"
//        Stream<WebElement> resultFiltered = searchResults
//                .filter(r -> r.findElement(By.cssSelector("div.r > a")).getAttribute("href").equals("http://agileszkolenia.pl/"));
//
//        // Now, let us convert stream to list - so that we can easily get elements out of it
//        List<WebElement> resultsList = resultFiltered.collect(Collectors.toList());
//
//        // Check that collection (our list) contains only one element
//        Assertions.assertEquals(1, resultsList.size());
//
//        // Pull element out of the list (by its index, 0 for the first and only element)
//        WebElement result = resultsList.get(0);
//
//        // Check that element contains proper link inside <cite>
//        // That means we have to find inside this web element HTML element cite, pull text out of it and compare it with expected text
//        Assertions.assertEquals("agileszkolenia.pl/", result.findElement(By.tagName("cite")).getText());
//
//    }
//
//    // This will execute after each test case (after each method annotated with @Test is executed)
//    @AfterEach
//    public void closeDriver() {
//        // Close Chrome browser
//        driver.quit();
//    }
//
//
//
//
//Na stronie gównej Word Press - metoda dodaj notkę, na notce Metoda dodaj komentarz i sprawdź czy jest