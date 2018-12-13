package selenium.pageObjects.NoweZadanie;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import selenium.pageObjects.NoweZadanie.pages.wpMainPage;
import selenium.pageObjects.NoweZadanie.pages.wpNotePage;

import java.util.UUID;

public class WordpressTest extends BaseTest {



    @Test
    public void canAddCommentToFirstNote() {
        //otwarcie nowej strony https://automatyzacja.benedykt.net/
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
        Assertions.assertTrue(LatestNoteWithComment.commentExist(comment, author));
        //Jeżeli strona się odświezy, to b

    }

    private String generateRandomEmail() {
        return generateRandomText() + "@testdomin.com";
    }

    //to się wygenerowało same poprzez storzenie generateRandomText
    private String generateRandomText() {
        //zwróć obiekt wygenerowany i zrób z niego stringa (tekst)
        return UUID.randomUUID().toString();
    }
}
