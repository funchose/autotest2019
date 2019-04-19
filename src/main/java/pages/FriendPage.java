package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import promise.WriteToFriendPromise;

public class FriendPage extends BasePage {

    public static final By WRITE_BUTTON = By.xpath(".//*[contains(@hrefattrs, 'FriendTopCardButtonsSendMessage')]");

    public FriendPage(WebDriver driver) {
        super(driver);
    }



    @Override
    public void check() {

    }

    private boolean findButton(){
        return isElementVisible(WRITE_BUTTON);
    }

    public WriteToFriendPromise getMyStatus(){
        boolean isButton = findButton();
        return new WriteToFriendPromise(driver, isButton);
    }

}
