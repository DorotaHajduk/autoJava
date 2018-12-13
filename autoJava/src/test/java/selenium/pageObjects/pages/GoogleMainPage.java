package selenium.pageObjects.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class GoogleMainPage {

    private static final String GOOGLE_PAGE_URL = "http://www.google.com";
    public static final By SEARCH_BOX_LOC = By.name("q");
    private final WebDriver gmpDriver;

//konstruktor klasy, który otrzymauje jako parametr webDrivera. Przekazujemy parametr do konstruktora o nazwie WebDriver.
// Żeby używać go poza konstruktorem i znana w całej naszej klasie, musimy ją zapisać
    public GoogleMainPage(WebDriver driver) {
        gmpDriver = driver;
        //otwieramy nową stronę googla (wyzej zdefiniowałam ja jako stała private)
        gmpDriver.get(GOOGLE_PAGE_URL);
    }

    //search jest z tekstem więc musi byc string. SearchQuery musimy przypisać
    public GoogleResultPage search(String searchQuery) {
//zapisujemy sobie referencje do search boxa.
        WebElement searchBox = gmpDriver.findElement(SEARCH_BOX_LOC);
        searchBox.sendKeys(searchQuery);
        searchBox.submit();
//po otwarciu strony z rezultatami musimy zwrócić nowy obiekt z wynikiem/rezultatem przegladania
        return new GoogleResultPage(gmpDriver);
    }
}
//kończy się tworzenie obiektu wiec wracamy do testu