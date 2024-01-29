package tests;


import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.CollectionCondition.sizeGreaterThan;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;
import static io.appium.java_client.AppiumBy.accessibilityId;
import static io.appium.java_client.AppiumBy.id;
import static io.qameta.allure.Allure.step;


@DisplayName("Мобильные автотесты")
public class Tests extends TestBase {

    @Test
    @Tag("android")
    @DisplayName("Проверка наличия результатов поиска")
    void searchInputTest() {

        step("Вводим поисковый запрос в поле поиска", () -> {
            $(accessibilityId("Search Wikipedia")).click();
            $(id("org.wikipedia.alpha:id/search_src_text")).sendKeys("Selenide");
        });
        step("Проверяем наличие результатов поиска", () ->
                $$(id("org.wikipedia.alpha:id/page_list_item_title"))
                        .shouldHave(sizeGreaterThan(0)));
    }

    @Test
    @Tag("android")
    @DisplayName("Открытие первого результата поиска")
    void openFoundContentTest() {

        step("Вводим поисковый запрос в поле поиска", () -> {
            $(accessibilityId("Search Wikipedia")).click();
            $(id("org.wikipedia.alpha:id/search_src_text")).sendKeys("Selenide");
        });
        step("Проверяем, что есть результаты поиска", () ->
                $$(id("org.wikipedia.alpha:id/page_list_item_title"))
                        .shouldHave(sizeGreaterThan(0)));
        step("Нажимаем на первый результат поиска", () ->
                $$(id("org.wikipedia.alpha:id/page_list_item_title")).first().click());
        step("Нажимаем на кнопку GO BACK", () ->
                $(id("org.wikipedia.alpha:id/view_wiki_error_button")).click());
    }

    @Tag("ios")
    @DisplayName("Наличие кнопки")
    @Test
    public void searchIosTest() {
        step("Проверяем, что кнопка видима", () -> {

            $(id("Text Button")).shouldBe(visible);
        });

    }
}
