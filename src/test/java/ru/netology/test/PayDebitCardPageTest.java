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
    void errorEmptyAllFieldsForm() {
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

    @Test
    void errorEmptyCardNumber() {
        ChoicePayPage choicePage = new ChoicePayPage();
        choicePage.choicePayPage();
        var payDebitCardPage = choicePage.payDebitCard();
        payDebitCardPage.cleanFormFields();
        payDebitCardPage.fillPayDebitCardForm(DataHelper.generateApprovedEmptyCardNumber());
        payDebitCardPage.sendButtonClick();
        payDebitCardPage.visibleCardFieldError("Неверный формат");
    }

    @Test
    void errorEmptyMonth() {
        ChoicePayPage choicePage = new ChoicePayPage();
        choicePage.choicePayPage();
        var payDebitCardPage = choicePage.payDebitCard();
        payDebitCardPage.cleanFormFields();
        payDebitCardPage.fillPayDebitCardForm(DataHelper.generateApprovedEmptyMonth());
        payDebitCardPage.sendButtonClick();
        payDebitCardPage.visibleMonthFieldError("Неверный формат");
    }

    @Test
    void errorEmptyYear() {
        ChoicePayPage choicePage = new ChoicePayPage();
        choicePage.choicePayPage();
        var payDebitCardPage = choicePage.payDebitCard();
        payDebitCardPage.cleanFormFields();
        payDebitCardPage.fillPayDebitCardForm(DataHelper.generateApprovedEmptyYear());
        payDebitCardPage.sendButtonClick();
        payDebitCardPage.visibleYearFieldError("Неверный формат");
    }

    @Test
    void errorEmptyName() {
        ChoicePayPage choicePage = new ChoicePayPage();
        choicePage.choicePayPage();
        var payDebitCardPage = choicePage.payDebitCard();
        payDebitCardPage.cleanFormFields();
        payDebitCardPage.fillPayDebitCardForm(DataHelper.generateApprovedEmptyName());
        payDebitCardPage.sendButtonClick();
        payDebitCardPage.visibleNameFieldError("Поле обязательно для заполнения");
    }

    @Test
    void errorEmptyCvv() {
        ChoicePayPage choicePage = new ChoicePayPage();
        choicePage.choicePayPage();
        var payDebitCardPage = choicePage.payDebitCard();
        payDebitCardPage.cleanFormFields();
        payDebitCardPage.fillPayDebitCardForm(DataHelper.generateApprovedEmptyCvv());
        payDebitCardPage.sendButtonClick();
        payDebitCardPage.visibleCvvFieldError("Неверный формат");
    }

    @Test
    void errorZeroCardNumber() {
        ChoicePayPage choicePage = new ChoicePayPage();
        choicePage.choicePayPage();
        var payDebitCardPage = choicePage.payDebitCard();
        payDebitCardPage.cleanFormFields();
        payDebitCardPage.fillPayDebitCardForm(DataHelper.generateZeroCardNumber());
        payDebitCardPage.sendButtonClick();
        payDebitCardPage.visibleErrorMessage("Ошибка! Банк отказал в проведении операции.");
    }

    @Test
    void errorInvalidCardNumber() {
        ChoicePayPage choicePage = new ChoicePayPage();
        choicePage.choicePayPage();
        var payDebitCardPage = choicePage.payDebitCard();
        payDebitCardPage.cleanFormFields();
        payDebitCardPage.fillPayDebitCardForm(DataHelper.generateInvalidCardNumber());
        payDebitCardPage.sendButtonClick();
        payDebitCardPage.visibleErrorMessage("Ошибка! Банк отказал в проведении операции.");
    }

    @Test
    void errorLossCardNumber() {
        ChoicePayPage choicePage = new ChoicePayPage();
        choicePage.choicePayPage();
        var payDebitCardPage = choicePage.payDebitCard();
        payDebitCardPage.cleanFormFields();
        payDebitCardPage.fillPayDebitCardForm(DataHelper.generatedLossCardNumber());
        payDebitCardPage.sendButtonClick();
        payDebitCardPage.visibleCardFieldError("Неверный формат");
    }

    @Test
    void errorLatinCardNumber() {
        ChoicePayPage choicePage = new ChoicePayPage();
        choicePage.choicePayPage();
        var payDebitCardPage = choicePage.payDebitCard();
        payDebitCardPage.cleanFormFields();
        payDebitCardPage.fillPayDebitCardForm(DataHelper.generatedLatinCardNumber());
        payDebitCardPage.sendButtonClick();
        payDebitCardPage.visibleCardFieldError("Неверный формат");
    }

    @Test
    void errorCyrilCardNumber() {
        ChoicePayPage choicePage = new ChoicePayPage();
        choicePage.choicePayPage();
        var payDebitCardPage = choicePage.payDebitCard();
        payDebitCardPage.cleanFormFields();
        payDebitCardPage.fillPayDebitCardForm(DataHelper.generatedCyrilCardNumber());
        payDebitCardPage.sendButtonClick();
        payDebitCardPage.visibleCardFieldError("Неверный формат");
    }

    @Test
    void errorSymbolCardNumber() {
        ChoicePayPage choicePage = new ChoicePayPage();
        choicePage.choicePayPage();
        var payDebitCardPage = choicePage.payDebitCard();
        payDebitCardPage.cleanFormFields();
        payDebitCardPage.fillPayDebitCardForm(DataHelper.generatedSymbolCardNumber());
        payDebitCardPage.sendButtonClick();
        payDebitCardPage.visibleCardFieldError("Неверный формат");
    }
}