package ru.netology.web.test;

import com.codeborne.selenide.Selenide;
import lombok.val;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.netology.web.data.DataHelper;
import ru.netology.web.page.LoginPage;
import ru.netology.web.sql.DbInteraction;

import static com.codeborne.selenide.Selenide.open;

public class AuthorizationTest {

    @BeforeEach
    void setUp() {
        open("http://localhost:9999");
        Selenide.clearBrowserCookies();
        Selenide.clearBrowserLocalStorage();
    }

    @Test
    void shouldAuthorization() {
        LoginPage loginPage = new LoginPage();
        val authInfo = DataHelper.getAuthInfo();
        val verificationPage = loginPage.validLogin(authInfo);
    }

    @AfterEach
    void cleanDb() {
        DbInteraction.deleteTables();
    }
}
