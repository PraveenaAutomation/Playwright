import annotations.PlaywrightPage;
import com.microsoft.playwright.*;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import pages.AccountNavigationPage;
import pages.CreateAccountPage;
import services.EnvironmentReaderService;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.util.Arrays;

public class PlaywrightRunner {
    protected Page page;
    protected BrowserContext browserContext;
    protected Browser browser;
    protected static Playwright playwright;
    @PlaywrightPage
    protected CreateAccountPage createAccountPage;
    @PlaywrightPage
    protected AccountNavigationPage accountNavigationPage;


    @BeforeAll
    public static void init() {
        playwright = Playwright.create();
    }

    @BeforeEach
    public void setup() {
        browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
        browserContext = browser.newContext(new Browser.NewContextOptions().setPermissions(Arrays.asList("geolocation")));
        page = browserContext.newPage();
        page.setViewportSize(1920, 1080);

        initPage(this, page);

        System.out.println("oki");
//        createAccountPage = new CreateAccountPage(page);
//        accountNavigationPage = new AccountNavigationPage(page);
    }

    private void initPage(Object object, Page page) {
        Class<?> classes = object.getClass().getSuperclass();
        for (Field field : classes.getDeclaredFields()) {
            if (field.isAnnotationPresent(PlaywrightPage.class)) {
                Class<?>[] type = {Page.class};
                try {
                    field.set(this, field.getType().getConstructor(type).newInstance(page));
                } catch (IllegalAccessException | InstantiationException | InvocationTargetException | NoSuchMethodException e) {
                    System.out.println("Did not manage to call constructor for playwright page with name " + field.getName());
                }
            }
        }
    }

    @AfterEach
    public void tearDown() {
        browserContext.close();
        browser.close();
    }

    protected String getProperty(String key) {
        return EnvironmentReaderService.getProperty(key);
    }
}
