package ru.netology.page;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class ChoicePayPage {
    private final SelenideElement heading = $(withText("Путешествие дня"));
    private final SelenideElement buyDebitButton = $$("button").findBy(text("Купить"));
    private final SelenideElement buyCreditButton = $$("button").findBy(text("Купить в кредит"));

    public void choicePayPage() {
        heading.shouldBe(visible);
    }

    public PayDebitCardPage payDebitCard() {
        buyDebitButton.click();
        return new PayDebitCardPage();
    }

    public PayCreditCardPage payCreditCard() {
        buyCreditButton.click();
        return new PayCreditCardPage();
    }
}
