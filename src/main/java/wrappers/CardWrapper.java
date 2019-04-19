package wrappers;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public final class CardWrapper {
    private static final By FRIEND_NAME = By.xpath(".//a[@class='n-t bold']");
    private static final By WRITE_BUTTON = By.xpath(".//a[contains(@class,'send-msg')]");

    private final WebElement friendCard;

    public CardWrapper(WebElement friendCard) {
        this.friendCard = friendCard;
    }

    public String getName() {
        return friendCard.findElement(FRIEND_NAME).getText();
    }

    public void clickToWriteMessage() {
        friendCard.findElement(WRITE_BUTTON).click();
    }

    public void clickToFriendName() {
        friendCard.findElement(FRIEND_NAME).click();
    }
}
