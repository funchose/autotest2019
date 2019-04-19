package pages;

import org.checkerframework.checker.nullness.compatqual.NullableDecl;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;

public class UserMainPage extends BasePage {
    public static final By FRIENDS = By.xpath("//a[@data-l='t,userFriend']");
    public static final By FEED = By.xpath("//div[contains(@class,'feed-list')]");
    private WebElement friendsButton;

    public UserMainPage(WebDriver driver) {
        super(driver);
        friendsButton = driver.findElement(FRIENDS);
    }

    @Override
    public void check() {
        Assert.assertTrue(
                "Кнопка 'Новости' не отобразилась",
                new WebDriverWait(driver, 2).until(
                        new ExpectedCondition<Boolean>() {
                            @NullableDecl
                            @Override
                            public Boolean apply(@NullableDecl WebDriver driver) {
                                return isElementVisible(FEED);
                            }
                        })
        );
    }

    public FriendsPage clickToFriends() {
        friendsButton.click();
        return new FriendsPage(driver);
    }
}
