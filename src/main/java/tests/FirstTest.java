package tests;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.FriendPage;
import pages.FriendsPage;
import pages.LoginPage;
import pages.UserMainPage;
import promise.WriteToFriendPromise;
import tests.TestBase;

import java.util.concurrent.TimeUnit;

import static org.junit.Assert.fail;


public class FirstTest extends TestBase {
    private WebDriver driver;
    private String baseUrl;
    private boolean acceptNextAlert = true;
    private StringBuffer verificationErrors = new StringBuffer();

    @Before
    public void setUp() throws Exception {
        driver = new ChromeDriver();
        baseUrl = "https://ok.ru/";
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
    }

    @Test
    public void testCase() throws Exception {
        driver.get(baseUrl + "/dk?st.cmd=anonymMain&st.layer.cmd=PopLayerClose");

        LoginPage loginPage = new LoginPage(driver);
        loginPage.login(" ", " ");

        UserMainPage userMainPage = new UserMainPage(driver);
        userMainPage.clickToFriends();

        FriendsPage friendsPage = new FriendsPage(driver);
        /*CardWrapper friend = friendsPage.getFriendCardByName("Алена Бабич");
        friend.clickToFriendName();*/

        FriendPage friendPage = friendsPage.getFriendPage("Алена Бабич");
        WriteToFriendPromise myStatus = friendPage.getMyStatus();
        myStatus.chooseYourDestiny();

        //ChatPage chatPage = new ChatPage(driver);

        //assertEquals(friend.getName(), chatPage.getChatName());


//        driver.findElement(By.linkText("Группы 41")).click();
//        driver.findElement(By.cssSelector("span.add-stub_tx")).click();
//        driver.findElement(By.cssSelector("div.create-group-dialog_tx")).click();
//        driver.findElement(By.id("field_name")).clear();
//        driver.findElement(By.id("field_name")).sendKeys("Group");
//        driver.findElement(By.id("hook_FormButton_button_create")).click();
    }

    @After
    public void tearDown() throws Exception {
        driver.quit();
        String verificationErrorString = verificationErrors.toString();
        if (!"".equals(verificationErrorString)) {
            fail(verificationErrorString);
        }
    }


}

