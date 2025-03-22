package ru.netology.page;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.Keys;
import ru.netology.data.DataHelper;

import java.time.Duration;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;
import static org.openqa.selenium.Keys.HOME;

public class PayDebitCardPage {
    private final SelenideElement heading = $(withText("Оплата по карте"));
    private final SelenideElement cardNumberField = $$(".input__inner").findBy(text("Номер карты")).$("input");
    private final SelenideElement monthField = $$(".input__inner").findBy(text("Месяц")).$("input");
    private final SelenideElement yearField = $$(".input__inner").findBy(text("Год")).$("input");
    private final SelenideElement nameField = $$(".input__inner").findBy(text("Владелец")).$("input");
    private final SelenideElement cvvField = $$(".input__inner").findBy(text("CVC/CVV")).$("input");
    private final SelenideElement sendButton = $$(".button").findBy(text("Продолжить"));

    private final SelenideElement successMessage = $(".notification_status_ok .notification__content");
    private final SelenideElement errorMessage = $(".notification_status_error .notification__content");

    private final SelenideElement cardFieldError = $$(".input__top")
            .findBy(text("Номер карты")).closest(".form-field").$(".input__sub");
    private final SelenideElement monthFieldError = $$(".input__top")
            .findBy(text("Месяц")).closest(".form-field").$(".input__sub");
    private final SelenideElement yearFieldError = $$(".input__top")
            .findBy(text("Год")).closest(".form-field").$(".input__sub");
    private final SelenideElement nameFieldError = $$(".input__top")
            .findBy(text("Владелец")).closest(".form-field").$(".input__sub");
    private final SelenideElement cvvFieldError = $$(".input__top")
            .findBy(text("CVC/CVV")).closest(".form-field").$(".input__sub");


    public PayDebitCardPage() {
        heading.shouldBe(visible);
    }

    public void cleanFormFields() {
        cardNumberField.sendKeys(Keys.chord(Keys.SHIFT, HOME), Keys.BACK_SPACE);
        monthField.sendKeys(Keys.chord(Keys.SHIFT, HOME), Keys.BACK_SPACE);
        yearField.sendKeys(Keys.chord(Keys.SHIFT, HOME), Keys.BACK_SPACE);
        nameField.sendKeys(Keys.chord(Keys.SHIFT, HOME), Keys.BACK_SPACE);
        cvvField.sendKeys(Keys.chord(Keys.SHIFT, HOME), Keys.BACK_SPACE);
    }

    public void fillPayDebitCardForm(DataHelper.AuthInfo authInfo) {
        cardNumberField.setValue(authInfo.getCardNumber());
        monthField.setValue(authInfo.getMonth());
        yearField.setValue(authInfo.getYear());
        nameField.setValue(authInfo.getName());
        cvvField.setValue(String.valueOf(authInfo.getCvvCode()));
        sendButton.click();
    }

    public void sendButtonClick() {
        sendButton.click();
    }

    public void visibleSuccessMessage(String message) {
        successMessage.shouldBe(visible, Duration.ofSeconds(15)).shouldHave(text(message));
    }

    public void visibleErrorMessage(String message) {
        errorMessage.shouldBe(visible, Duration.ofSeconds(15)).shouldHave(text(message));
    }

    public void visibleCardFieldError(String message) {
        cardFieldError.shouldBe(visible).shouldHave(text(message));
    }

    public void visibleMonthFieldError(String message) {
        monthFieldError.shouldBe(visible).shouldHave(text(message));
    }

    public void visibleNameFieldError(String message) {
        nameFieldError.shouldBe(visible).shouldHave(text(message));
    }

    public void visibleYearFieldError(String message) {
        yearFieldError.shouldBe(visible).shouldHave(text(message));
    }

    public void visibleCvvFieldError(String message) {
        cvvFieldError.shouldBe(visible).shouldHave(text(message));
    }

}
