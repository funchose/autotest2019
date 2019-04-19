package promise;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import pages.ChatPage;

public class WriteToFriendPromise {

    private WebDriver driver;
    private boolean isButton;
    private static final By WRITE_BUTTON = By.xpath(".//*[contains(@hrefattrs, 'FriendTopCardButtonsSendMessage')]");

    public WriteToFriendPromise(WebDriver driver, boolean isButton) {
        this.driver = driver;
        this.isButton = isButton;
    }

    public void chooseYourDestiny(){
        if (isButton) andCanWrite();
        else andCantWrite();
    }

    private ChatPage andCanWrite(){
        driver.findElement(WRITE_BUTTON).click();
        return new ChatPage(driver);
    }

    private void andCantWrite(){
        System.out.println("Дуров, верни стену!");
    }

}
