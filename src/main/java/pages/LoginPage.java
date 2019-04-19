package pages;

import org.checkerframework.checker.nullness.compatqual.NullableDecl;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage extends BasePage {

    private static final By FORGOT_PASSWORD_BUTTON = By.xpath("//a[contains(@href,'ForgotPassword')]");

    public LoginPage(WebDriver driver) {
        super(driver);

        check();
    }

    @Override
    public void check() {
        Assert.assertTrue(
                "Кнопка 'Забыл пароль' не отобразилась",
                new WebDriverWait(driver, 2).until(
                        new ExpectedCondition<Boolean>() {
                            @NullableDecl
                            @Override
                            public Boolean apply(@NullableDecl WebDriver driver) {
                                return isElementVisible(FORGOT_PASSWORD_BUTTON);
                            }
                        })
        );
    }

    public UserMainPage login(String email, String password) {
        driver.findElement(By.id("field_email")).clear();
        driver.findElement(By.id("field_email")).sendKeys(email);
        driver.findElement(By.id("field_password")).clear();
        driver.findElement(By.id("field_password")).sendKeys(password);
        driver.findElement(By.cssSelector("div.form-actions > div > input.button-pro.__wide")).click();
        UserMainPage userMainPage = new UserMainPage(driver);
        return userMainPage;
    }
}




