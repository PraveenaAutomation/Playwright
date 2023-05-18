import com.microsoft.playwright.*;
import com.microsoft.playwright.options.AriaRole;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

public class TestPlaywright {

    @Test
    public void test(){
//        System.out.println("hello");
        Playwright playwright = Playwright.create();
        Browser browser = playwright.firefox().launch(new BrowserType.LaunchOptions().setHeadless(false));
        BrowserContext browserContext = browser.newContext(new Browser.NewContextOptions().setPermissions(Arrays.asList("geolocation")));
        Page page = browserContext.newPage();

        page.navigate("https://www.bestbuy.com/?intl=nosplash");
        page.setViewportSize(1848, 980);

//        page.locator("//a[@data-lid='hdr_dotd']").click();
//        page.locator("//button//*[text()='Account']").click();

        page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Account")).click();
        page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Sign In")).click();


        System.out.println("hello");
    }
}
