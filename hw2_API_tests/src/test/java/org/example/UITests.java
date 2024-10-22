package org.example;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selectors;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.element;

public class UITests {
    @Test
    public void userCanNotRegisterWithNameAndSurnameOnly() {
        //Подготовка
        Selenide.open("https://parabank.parasoft.com/parabank/register.htm");

        //Шаги теста
        SelenideElement firstName = element(Selectors.byId("customer.firstName"));
        firstName.sendKeys("Andrew");

        SelenideElement lastName = element(Selectors.byId("customer.lastName"));
        lastName.sendKeys("Dolgov");

        SelenideElement registerButton = element(Selectors.byValue("Register"));
        registerButton.click();

        //Проверка ОР: наличие подсказки у обязательных полей
        SelenideElement addressError = element(Selectors.byId("customer.address.street.errors"));
        addressError.shouldHave(Condition.exactText("Address is required."));

        SelenideElement cityError = element(Selectors.byId("customer.address.city.errors"));
        cityError.shouldHave(Condition.exactText("City is required."));

        SelenideElement stateError = element(Selectors.byId("customer.address.state.errors"));
        stateError.shouldHave(Condition.exactText("State is required."));

        SelenideElement zipCodeError = element(Selectors.byId("customer.address.zipCode.errors"));
        zipCodeError.shouldHave(Condition.exactText("Zip Code is required."));

        SelenideElement ssnError = element(Selectors.byId("customer.ssn.errors"));
        ssnError.shouldHave(Condition.exactText("Social Security Number is required."));

        SelenideElement usernameError = element(Selectors.byId("customer.username.errors"));
        usernameError.shouldHave(Condition.exactText("Username is required."));

        SelenideElement passwordError = element(Selectors.byId("customer.password.errors"));
        passwordError.shouldHave(Condition.exactText("Password is required."));

        SelenideElement repeatedPasswordError = element(Selectors.byId("repeatedPassword.errors"));
        repeatedPasswordError.shouldHave(Condition.exactText("Password confirmation is required."));

    }

    @Test
    public void userCanRegisterByFillingAllRequiredFields() {
        //Подготовка
        Selenide.open("https://parabank.parasoft.com/parabank/register.htm");

        //Шаги теста: заполнение обязательных полей
        SelenideElement firstName = element(Selectors.byId("customer.firstName"));
        firstName.sendKeys("Andrew");

        SelenideElement lastName = element(Selectors.byId("customer.lastName"));
        lastName.sendKeys("Dolgov");

        SelenideElement address = element(Selectors.byId("customer.address.street"));
        address.sendKeys("Nauki prospect");

        SelenideElement city = element(Selectors.byId("customer.address.city"));
        city.sendKeys("Saint-Petersburg");

        SelenideElement state = element(Selectors.byId("customer.address.state"));
        state.sendKeys("Russia");

        SelenideElement zipCode = element(Selectors.byId("customer.address.zipCode"));
        zipCode.sendKeys("12345");

        SelenideElement ssn = element(Selectors.byId("customer.ssn"));
        ssn.sendKeys("98765");

        String username = "andrewD";
        SelenideElement usernameField = element(Selectors.byId("customer.username"));
        usernameField.sendKeys(username);

        SelenideElement password = element(Selectors.byId("customer.password"));
        password.sendKeys("Qwerty123");

        SelenideElement repeatedPassword = element(Selectors.byId("repeatedPassword"));
        repeatedPassword.sendKeys("Qwerty123");

        SelenideElement registerButton = element(Selectors.byValue("Register"));
        registerButton.click();

        //Проверка ОР: появление сообщения об успешной регистрации
        SelenideElement greetingMessage = element(Selectors.byId("rightPanel"));
        greetingMessage.shouldBe(visible);

        $("#rightPanel h1").shouldHave(text("Welcome " + username));

        $("#rightPanel p").shouldHave(text("Your account was created successfully. You are now logged in."));

    }

}
