package com.example;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Selectors.byText;

public class DragAndDrop {

    @BeforeAll
    static void configure() {
        Configuration.baseUrl = "https://the-internet.herokuapp.com/";
        Configuration.browserSize = "1920x1080";
    }
//          НЕ РАБОТАЕТ
//    @Test
//    void testMoveToElementAndMoveByOffset() {
//        open("drag_and_drop");
//        actions().moveToElement($("#column-a")).clickAndHold()
//                .moveToElement($("#column-b")).release().perform();
//        $("div#column-b").shouldHave(text("A"));
//    }

    @Test
    void testDragAndDrop() {
        open("drag_and_drop");
        $("#column-a").dragAndDropTo($("#column-b"));
        $("div#column-b").shouldHave(text("A"));
        $("div#column-a").shouldHave(text("B"));

        sleep(2000);
    }
}
