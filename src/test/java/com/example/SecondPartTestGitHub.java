package com.example;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class SecondPartTestGitHub {

    @BeforeAll
    static void configure() {
        Configuration.baseUrl = "https://github.com";
        Configuration.browserSize = "1920x1080";
    }

    @Test
    void shouldFindTextOnPage() {
        open("https://github.com/");
        $("[role=\"banner\"]").$(byText("Pricing")).hover();
        $(".HeaderMenu").$(byText("Compare plans")).click();
        $("h1.h2-mktg").shouldHave(text("Choose the plan that’s right for you."));
    }
}


