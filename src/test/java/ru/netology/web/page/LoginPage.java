package ru.netology.web.page;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.Keys;
import ru.netology.web.data.DataHelper;

import static com.codeborne.selenide.Selenide.$;

public class LoginPage {
    private final SelenideElement loginField = $("[data-test-id=login] input");
    private final SelenideElement passwordField = $("[data-test-id=password] input");
    private final SelenideElement loginButton = $("[data-test-id=action-login]");
    private final SelenideElement errorNotification = $("[data-test-id=error-notification]");

    public VerificationPage validLogin(DataHelper.AuthInfo info) {
        loginField.setValue(info.getLogin());
        passwordField.setValue(info.getPassword());
        loginButton.click();
        return new VerificationPage();
    }

    public void getInvalidLogin() {
        errorNotification.shouldBe(Condition.visible).shouldHave(Condition.text("Ошибка! "));
    }

    public void getBlockedMessage() {
        errorNotification.shouldBe(Condition.visible).shouldHave(Condition.text("Система заблокирована"));
    }

    public void cleaning() {
        loginField.doubleClick().sendKeys(Keys.BACK_SPACE);
        passwordField.doubleClick().sendKeys(Keys.BACK_SPACE);
    }
}
