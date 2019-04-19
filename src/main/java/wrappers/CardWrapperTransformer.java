package wrappers;

import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class CardWrapperTransformer {

    private CardWrapperTransformer() {}

    public static List<CardWrapper> wrap(List<WebElement> elements) {
        if (elements.isEmpty()) {
            return Collections.emptyList();
        }
        List<CardWrapper> friends = new ArrayList<>();
        for (WebElement element : elements) {
            friends.add(new CardWrapper(element));
        }
        return friends;
    }

}
