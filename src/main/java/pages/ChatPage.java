package pages;

import org.checkerframework.checker.nullness.compatqual.NullableDecl;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ChatPage extends BasePage{
    private static final By CHAT_NAME = By.xpath("//span[contains(@data-l,'opponent_name')]");
    private static final By CLOSE_CHAT_BUTTON = By.xpath("//div[contains(@class,'close') and contains(@data-l,'closeLayer')]");
    public ChatPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public void check() {
        Assert.assertTrue(
                "Кнопка 'Закрыть чат' не отобразилась",
                new WebDriverWait(driver, 2).until(
                        new ExpectedCondition<Boolean>() {
                            @NullableDecl
                            @Override
                            public Boolean apply(@NullableDecl WebDriver driver) {
                                return isElementVisible(CLOSE_CHAT_BUTTON);
                            }
                        })
        );
    }

    public String getChatName() {
        return driver.findElement(CHAT_NAME).getText();
    }
}
