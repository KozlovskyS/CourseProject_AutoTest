package ru.netology.data;

import com.github.javafaker.Faker;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.Value;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;
import java.util.Random;

import static java.lang.String.valueOf;

public class DataHelper {

    private DataHelper() {
    }

    public static String getApprovedCardNumber() {
        return new String("1111 2222 3333 4444");
    }

    public static String getDeclinedCardNumber() {
        return new String("5555 6666 7777 8888");
    }

    public static String generateRandomCardNumber() {
        Faker faker = new Faker();
        return faker.numerify("################");
    }

    public static String generateLossCardNumber() {
        Faker faker = new Faker();
        return faker.numerify("###############");
    }

    private static String generateRandomName(String locale) {
        Faker faker = new Faker(new Locale(locale));
        return faker.name().username();
    }

    private static String generateRandomSymbols() {
        Faker faker = new Faker();
        return faker.internet().password();
    }

    public static String generateValidMonth() {
        return LocalDate.now().format(DateTimeFormatter.ofPattern("MM"));
    }

    public static String generateValidYear() {
        return LocalDate.now().format(DateTimeFormatter.ofPattern("yy"));
    }

    public static String generatePastMonth() { //прошедший месяц
        return LocalDate.now().minusMonths(1).format(DateTimeFormatter.ofPattern("MM"));
    }

    public static String generatePastYear() {  //прошедший год
        return LocalDate.now().minusYears(1).format(DateTimeFormatter.ofPattern("yy"));
    }

    public static String generateInvalidMonth() {
        int invalidMonth = new Random().nextInt(87) + 13; // неправильный месяц с 13 по 99
        return valueOf(invalidMonth);
    }

    public static CvvCode generateRandomCvvCode() {
        Faker faker = new Faker();
        return new CvvCode(faker.numerify("###"));
    }

    public static CvvCode generateInvalidCvvCode() {
        Faker faker = new Faker();
        return new CvvCode(faker.numerify("##"));
    }

    public static String generateEmptyField() {
        return "";
    }

    // создание данных для авторизации
    public static AuthInfo generateValidApprovedUser() {
        return new AuthInfo(getApprovedCardNumber(), generateValidMonth(), generateValidYear(), generateRandomName("en"), generateRandomCvvCode());
    }

    public static AuthInfo generateValidDeclinedUser() {
        return new AuthInfo(getDeclinedCardNumber(), generateValidMonth(), generateValidYear(), generateRandomName("en"), generateRandomCvvCode());
    }

    public static AuthInfo generateApprovedEmptyCardNumber() {
        return new AuthInfo("", generateValidMonth(), generateValidYear(), generateRandomName("en"), generateRandomCvvCode());
    }

    public static AuthInfo generateApprovedEmptyMonth() {
        return new AuthInfo(getApprovedCardNumber(), "", generateValidYear(), generateRandomName("en"), generateRandomCvvCode());
    }

    public static AuthInfo generateApprovedEmptyYear() {
        return new AuthInfo(getApprovedCardNumber(), generateValidMonth(), "", generateRandomName("en"), generateRandomCvvCode());
    }

    public static AuthInfo generateApprovedEmptyName() {
        return new AuthInfo(getApprovedCardNumber(), generateValidMonth(), generateValidYear(), "", generateRandomCvvCode());
    }

    public static AuthInfo generateApprovedEmptyCvv() {
        return new AuthInfo(getApprovedCardNumber(), generateValidMonth(), generateValidYear(), generateRandomName("en"), null);
    }

    public static AuthInfo generateZeroCardNumber() {
        return new AuthInfo("0000000000000000", generateValidMonth(), generateValidYear(), generateRandomName("en"), generateRandomCvvCode());
    }

    public static AuthInfo generateInvalidCardNumber() {
        return new AuthInfo(generateRandomCardNumber(), generateValidMonth(), generateValidYear(), generateRandomName("en"), generateRandomCvvCode());
    }

    public static AuthInfo generatedLossCardNumber() {
        return new AuthInfo(generateLossCardNumber(), generateValidMonth(), generateValidYear(), generateRandomName("en"), generateRandomCvvCode());
    }

    public static AuthInfo generatedLatinCardNumber() {
        return new AuthInfo(generateRandomName("en"), generateValidMonth(), generateValidYear(), generateRandomName("en"), generateRandomCvvCode());
    }

    public static AuthInfo generatedCyrilCardNumber() {
        return new AuthInfo(generateRandomName("ru"), generateValidMonth(), generateValidYear(), generateRandomName("en"), generateRandomCvvCode());
    }

    public static AuthInfo generatedSymbolCardNumber() {
        return new AuthInfo(generateRandomSymbols(), generateValidMonth(), generateValidYear(), generateRandomName("en"), generateRandomCvvCode());
    }

    public static AuthInfo generateApprovedZeroMonth() {
        return new AuthInfo(getApprovedCardNumber(), "00", generateValidYear(), generateRandomName("en"), generateRandomCvvCode());
    }

    public static AuthInfo generateApprovedInValidMonth() {
        return new AuthInfo(getApprovedCardNumber(), generateInvalidMonth(), generateValidYear(), generateRandomName("en"), generateRandomCvvCode());
    }

    public static AuthInfo generateApprovedPastMonth() {
        return new AuthInfo(getApprovedCardNumber(), generatePastMonth(), generateValidYear(), generateRandomName("en"), generateRandomCvvCode());
    }

    public static AuthInfo generateApprovedPastYear() {
        return new AuthInfo(getApprovedCardNumber(), generateValidMonth(), generatePastYear(), generateRandomName("en"), generateRandomCvvCode());
    }

    public static AuthInfo generateApprovedCyrillicName() {
        return new AuthInfo(getApprovedCardNumber(), generateValidMonth(), generateValidYear(), generateRandomName("ru"), generateRandomCvvCode());
    }

    public static AuthInfo generateApprovedNumberName() {
        return new AuthInfo(getApprovedCardNumber(), generateValidMonth(), generateValidYear(), "2346", generateRandomCvvCode());
    }

    public static AuthInfo generateApprovedInValidCvv() {
        return new AuthInfo(getApprovedCardNumber(), generateValidMonth(), generateValidYear(), generateRandomName("en"), generateInvalidCvvCode());
    }


    @Value
    public static class AuthInfo {
        private String cardNumber;
        private String month;
        private String year;
        private String name;
        private CvvCode cvvCode;
    }

    @NoArgsConstructor
    @AllArgsConstructor
    @Data
    public static class CvvCode {
        String cvvCode;
    }
}
