import com.microsoft.playwright.*;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

public class First extends PlaywrightRunner{

    @Test
    public void firstTest(){
//        System.out.println("This works!");
//        Playwright playwright = Playwright.create();
//        Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
//        BrowserContext browserContext = browser.newContext(new Browser.NewContextOptions().setPermissions(Arrays.asList("geolocation")));
//        Page page = browserContext.newPage();
        page.navigate(getProperty("url"));
//        page.locator("//a[@data-lid='hdr_dotd']").click();
//        page.locator("[data-lid=hdr_dotd]").click();
//        page.locator("a:has-text(\"Deal of the Day\")").click();
//        Locator locator = page.locator("a:has-text(\"Deal of the Day\")");
//        locator.hover();
//        locator.click();
        Locator menuItems = page.locator("ul.bottom-nav-left li a");
//        System.out.println(menuItems.allTextContents());

        for(int i = 0; i<menuItems.count(); i++){
            System.out.println(menuItems.nth(i).textContent());
        }

        page.locator("ul.bottom-nav-left li a", new Page.LocatorOptions().setHasText("Deal of the Day")).click();

    }
}
