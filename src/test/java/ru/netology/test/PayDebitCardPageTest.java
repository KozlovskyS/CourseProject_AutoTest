package ru.netology.test;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.netology.data.DataHelper;
import ru.netology.page.ChoicePayPage;

import static com.codeborne.selenide.Selenide.open;
import static org.junit.jupiter.api.Assertions.*;

class PayDebitCardPageTest {

    @BeforeEach
    void setUp() {
        open("http://localhost:8080");
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void successPayApprovedCard() {
        ChoicePayPage choicePage = new ChoicePayPage();
        choicePage.choicePayPage();
        var payDebitCardPage = choicePage.payDebitCard();
        payDebitCardPage.cleanFormFields();
        payDebitCardPage.fillPayDebitCardForm(DataHelper.generateValidApprovedUser());
        payDebitCardPage.sendButtonClick();
        payDebitCardPage.visibleSuccessMessage("Операция одобрена Банком");
    }

    @Test
    void errorPayDeclinedCard() {
        ChoicePayPage choicePage = new ChoicePayPage();
        choicePage.choicePayPage();
        var payDebitCardPage = choicePage.payDebitCard();
        payDebitCardPage.cleanFormFields();
        payDebitCardPage.fillPayDebitCardForm(DataHelper.generateValidDeclinedUser());
        payDebitCardPage.sendButtonClick();
        payDebitCardPage.visibleErrorMessage("Ошибка! Банк отказал в проведении операции.");
    }

    @Test
    void errorEmptyFieldsForm() {
        ChoicePayPage choicePage = new ChoicePayPage();
        choicePage.choicePayPage();
        var payDebitCardPage = choicePage.payDebitCard();
        payDebitCardPage.cleanFormFields();
        payDebitCardPage.sendButtonClick();
        payDebitCardPage.visibleCardFieldError("Неверный формат");
        payDebitCardPage.visibleMonthFieldError("Неверный формат");
        payDebitCardPage.visibleYearFieldError("Неверный формат");
        payDebitCardPage.visibleNameFieldError("Поле обязательно для заполнения");
        payDebitCardPage.visibleCvvFieldError("Неверный формат");

    }
}