package pages;

import org.checkerframework.checker.nullness.compatqual.NullableDecl;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;
import wrappers.CardWrapper;
import wrappers.CardWrapperTransformer;

import java.util.List;

public class FriendsPage extends BasePage {
    private static final By FRIEND_CARDS = By.xpath(".//ul[@class='ugrid_cnt']/li");
    private static final By FRIENDS_ONLINE = By.xpath(".//a[contains(@hrefattrs,'online')]");

    public FriendsPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public void check() {
        Assert.assertTrue(
                "Кнопка 'Онлайн' не отобразилась",
                new WebDriverWait(driver, 2).until(
                        new ExpectedCondition<Boolean>() {
                            @NullableDecl
                            @Override
                            public Boolean apply(@NullableDecl WebDriver driver) {
                                return isElementVisible(FRIENDS_ONLINE);
                            }
                        })
        );
    }

    private List<CardWrapper> findAllFriendCards() {
        List<WebElement> friendCards = driver.findElements(FRIEND_CARDS);
        return CardWrapperTransformer.wrap(friendCards);
    }

    public CardWrapper getFriendCardByName(String friendName) {
        List<CardWrapper> friends = findAllFriendCards();
        for (CardWrapper friend : friends) {
            if (friend.getName().equals(friendName)) {
                return friend;
            }
        }
        return null;
    }

    public FriendPage getFriendPage(String friendName){
        CardWrapper friend = getFriendCardByName(friendName);
        friend.clickToFriendName();
        return new FriendPage(driver);
    }

}
