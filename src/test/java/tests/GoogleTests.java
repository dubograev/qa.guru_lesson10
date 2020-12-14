package tests;

import config.ConfigHelper;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selectors.byName;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class GoogleTests {

    @Test
    void selenideSearchTest() {
        String searchSite = ConfigHelper.getSearchSite();
        String searchItem = ConfigHelper.getSearchItem();
        String searchResult = ConfigHelper.getSearchResult();

        // Открыть google
        open(searchSite);

        // Ввести Selenide в поиск
        $(byName("q")).setValue(searchItem).pressEnter();

        // Проверить, что Selenide появился в результатах поиска
        $("html").shouldHave(text(searchResult));
    }
}
