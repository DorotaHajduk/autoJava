package selenium.pageObjects.pages;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.stream.Stream;


public class GoogleResultPage {
    private final WebDriver grpDriver;
    public static final By RESULT_LOC = By.cssSelector("#search .rc .r");

    public GoogleResultPage(WebDriver driver) {
        grpDriver = driver;
    }

    public boolean contains(String resutlUrl) {
//znajdz mi rezultaty po URL
        Stream<WebElement> results = getResultByUrl(resutlUrl);
//zrób streama, który ma wszystkie elementy. Jeżeli ilośc rezultatów jest większa od stream zwróć true (jeżeli rezultat ma conajmniej jedednego URL) jeżeli nie zwróic to false
        //wykonalismy bardzo rozpisany warunek. Narzedzie upraszcza zapis simplyfile 'if else'
        if (results.count() > 0) {
            return true;
        } else {
            return false;
        }
    }
//2.2.spodziewamy się, że mamy url, którego szukam więc robimy stream i filtruję sobie.
    public boolean containsResultWithTitle(String pageUrl, String pageTitle) {
        Stream<WebElement> results = getResultByUrl(pageUrl)
                .filter(r -> r.findElement(By.tagName("h3")).getText().equals(pageTitle));

        if (results.count() > 0) {
            return true;
        } else {
            return false;
        }
    }
//metoda rezultatu URL. Metoda prywatna bo nigdzi eindziej nie bedzie z niej korzystać wiec zawieramy ją tylko w tej klasie. Na zewnątrz nie będziemy jej wołać
    //zwraca stream, jakiego url szukamy (po lokatorze zdefiniowanym na samej górze
    // wewnatrz każdego rezultatu wyciągam taga Ancore i atrybut href. Jak wyczesze te wszystkie stronki , zamieniam listę na streama i dzięki temu mogę pofiltrować. Zwracam ten stream i moge zapisac go do result.
    // patrze co mi zostało po filtrowaniu (wyzej) i zwracamy te dane do googleTest
    private Stream<WebElement> getResultByUrl(String resutlUrl) {
        return grpDriver.findElements(RESULT_LOC)
                .stream()
                .filter(r -> r.findElement(By.tagName("a")).getAttribute("href").equals(resutlUrl));
    }
}
