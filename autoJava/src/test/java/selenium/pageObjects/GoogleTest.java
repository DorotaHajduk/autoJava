package selenium.pageObjects;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import selenium.pageObjects.pages.GoogleMainPage;
import selenium.pageObjects.pages.GoogleResultPage;

public class GoogleTest extends BaseTest {

    @Test
    public void canFindScrumOrgOnGoogle() {
        String pageUrl = "https://www.scrum.org/";
        String pageTitle = "Scrum.org: Homepage";

        // Open Google Main Page - stwórz nowy obiekt
        GoogleMainPage googlePage = new GoogleMainPage(driver);

        // Search For Scrum.org
        GoogleResultPage resultPage = googlePage.search("Scrum.org");

        // Assert Scrum.org page is found
        Assertions.assertTrue(resultPage.contains(pageUrl));
        Assertions.assertTrue(resultPage.containsResultWithTitle(pageUrl, pageTitle),
                "Scrum.org page has correct title");
    }

    @Test
    public void canFindCodeSprinters(){
        String pageUrl = "http://agileszkolenia.pl/";
        String pageTitle = "Code Sprinters - Agile Experts -";

        GoogleMainPage googlePage = new GoogleMainPage(driver);
        GoogleResultPage resultPage = googlePage.search("Code Sprinters");
        //strona reultatów zawiera rezultat z danym url. trzeba zdefiniować najpierw to w .
        //najlepiej używać asercji, która wraca true/false. Nie używamy tutaj driverów.
        Assertions.assertTrue(resultPage.contains(pageUrl));
        //jak wiemy , że jest przynajmniej jeden url, to  przechodzimy do rezultatów (metoda)2.2.
        Assertions.assertTrue(resultPage.containsResultWithTitle(pageUrl, pageTitle));
    }

}
