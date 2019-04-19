package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;

public abstract class BasePage {
     protected final WebDriver driver;

     public BasePage(WebDriver driver){
          this.driver = driver;
     }

     public abstract void check();

     protected boolean isElementVisible(By locator) {
          boolean isVisible = false;
          try{
               isVisible = driver.findElement(locator).isDisplayed();
          } catch (NoSuchElementException e){
               e.printStackTrace();
          }

          return isVisible;
     }
}
