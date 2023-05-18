import org.junit.jupiter.api.Test;
import pages.AccountEntries;
import services.EnvironmentReaderService;


import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;

public class SignUpTest extends PlaywrightRunner{

    @Test
    public void signUp(){
        page.navigate(getProperty("url"));
        accountNavigationPage.navigateTo(AccountEntries.CREATE_ACCOUNT);
        createAccountPage.createAccount();

        assertThat(page.locator("//button[@data-track='Create Account']")).isEnabled();
        System.out.println("hello");
    }
}
